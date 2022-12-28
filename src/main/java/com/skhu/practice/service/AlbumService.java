package com.skhu.practice.service;

import com.skhu.practice.dto.AlbumRequestDto;
import com.skhu.practice.entity.Album;
import com.skhu.practice.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public boolean save(AlbumRequestDto albumRequestDto) { // 여기에 validate 코드를 집어넣어서, 잘 못 입력한 경우 다시 redirection 할 수 있도록
        if (albumRequestDto.isNotIllegal()) { // isNotIllegal 할 때에만 하잖아
            System.out.println("what the fuck are you doing");
            albumRepository.save(Album.builder()
                    .name(albumRequestDto.getName())
                    .artistName(albumRequestDto.getArtistName())
                    .songsInAlbum(albumRequestDto.extractSongsInAlbum())
                    .dateOfIssue(albumRequestDto.getDateOfIssue())
                    .introduction(albumRequestDto.getIntroduction()).build());
            return true;
        }

        return false;
    }
}
