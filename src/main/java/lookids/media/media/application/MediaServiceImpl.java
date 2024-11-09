package lookids.media.media.application;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lookids.media.common.entity.BaseResponseStatus;
import lookids.media.common.exception.BaseException;
import lookids.media.media.domain.Media;
import lookids.media.media.dto.in.MediaDeleteDto;
import lookids.media.media.dto.in.MediaRequestDto;
import lookids.media.media.dto.in.MediaUpdateDto;
import lookids.media.media.dto.out.MediaResponseDto;
import lookids.media.media.infrastructure.MediaRepository;

@Service
@AllArgsConstructor
@Slf4j
public class MediaServiceImpl implements MediaService {

	private final MediaRepository mediaRepository;

	@Override
	public void createMedia(MediaRequestDto mediaRequestDto) {
		mediaRepository.save(mediaRequestDto.toEntity());
	}

	@Override
	public void updateMedia(MediaUpdateDto mediaUpdateDto) {
		Media media = mediaRepository.findByMediaCodeAndState(mediaUpdateDto.getMediaCode(), true)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_DATA));
		mediaRepository.save(mediaUpdateDto.toEntity(media));
	}

	@Override
	public void deleteMedia(MediaDeleteDto mediaDeleteDto) {
		Media media = mediaRepository.findByMediaCodeAndState(mediaDeleteDto.getMediaCode(), true)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_DATA));
		mediaRepository.save(mediaDeleteDto.toEntity(media));
	}

	@Override
	public MediaResponseDto readMedia(String mediaCode) {
		return MediaResponseDto.toDto(mediaRepository.findByMediaCodeAndState(mediaCode, true)
			.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_DATA)));
	}

	@Override
	public List<MediaResponseDto> readMediaList(String userUuid) {
		List<Media> mediaList = mediaRepository.findByUserUuid(userUuid);
		return mediaList.stream().map(MediaResponseDto::toDto).toList();
	}
}
