package com.application.web.services.member;

import com.application.common.Constant;
import com.application.common.exception.custom.CustomApiException;
import com.application.common.exception.custom.CustomValidException;
import com.application.domain.member.dto.MemberUpdateDto;
import com.application.domain.member.entity.Member;
import com.application.domain.member.enums.Gender;
import com.application.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(Member member){
        memberRepository.save(member);
    }

    public Member getMemberByCredentialId(String credentialId){
        return memberRepository.findByCreadentialId(credentialId);
    }

    public Member updateMemberInfo(Member member, MemberUpdateDto setInitMember){

        member.setGender(Gender.fromString(setInitMember.getGender())
                .orElseThrow(() -> new CustomApiException("Invalid Gender Type")));
        member.setNickname(setInitMember.getNickName());
        member.setName(setInitMember.getName() == null ? member.getName() : setInitMember.getName());
        member.setAddr(setInitMember.getAddr()== null ? member.getAddr() : setInitMember.getAddr());
        member.setAge(setInitMember.getAge()== null ? member.getAge() : setInitMember.getAge());
        member.setProfile(setInitMember.getProfile()==null ? member.getProfile() : setInitMember.getProfile());

        //업데이트문
        memberRepository.save(member);

        return member;
    }

    public void deleteMember(Long memberId){
        memberRepository.deleteById(memberId);
    }

    public Map<String, Object> getProfile(String credentialId){

        Member member = getMemberByCredentialId(credentialId);
        String ext = extractExt(member.getProfile());
        Path fullFilePath = Paths.get(Constant.UPLOAD_DIR + member.getProfile());
        Map<String, Object> map = new HashMap<>();
        map.put("ext", filterExt(ext));
        map.put("uri", fullFilePath.toUri());

        return map;
    }

    private MediaType filterExt(String ext){
        if("jpeg".equalsIgnoreCase(ext)){
            return MediaType.IMAGE_JPEG;
        }else if("png".equalsIgnoreCase(ext)){
            return MediaType.IMAGE_PNG;
        }else if("gif".equalsIgnoreCase(ext)){
            return MediaType.IMAGE_GIF;
        }else{
            throw new RuntimeException("fail filter MediaType");
        }
    }

    public Boolean saveProfile(String credentialId, MultipartFile file){

        try {
            if(file.getOriginalFilename() != null){
                String ext = extractExt(file.getOriginalFilename());
                String fileName = saveProfileToMember(credentialId, ext);
                Path filePath = Paths.get(Constant.UPLOAD_DIR + fileName);
                Files.createDirectories(filePath.getParent());
                file.transferTo(filePath);
                return true;
            }else{
                return false;
            }
        }catch(IOException e){
            throw new RuntimeException("fail to save file", e);
        }

    }

    private String extractExt(String fullFileName){
        List<String> splitFileName = Arrays.stream(fullFileName.split(".")).toList();
        int lastIndex = splitFileName.size()-1;
        return splitFileName.get(lastIndex);
    }

    private String saveProfileToMember(String credentialId, String ext){
        Member member = getMemberByCredentialId(credentialId);
        deleteOldProfile(member.getProfile());

        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "." + ext;
        member.setProfile(fileName);

        return fileName;
    }

    private void deleteOldProfile(String fileName){
        File file = new File(Constant.UPLOAD_DIR + fileName);
        if (file.exists()){
            if(file.delete()){
                log.info("file delete");
            }else{
                log.error("file delete fail");
            }
        }else{
            log.info("no file exist");
        }
    }

}
