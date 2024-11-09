package lookids.media.media.application;

import java.util.List;

import lookids.media.media.dto.in.MediaDeleteDto;
import lookids.media.media.dto.in.MediaRequestDto;
import lookids.media.media.dto.in.MediaUpdateDto;
import lookids.media.media.dto.out.MediaResponseDto;

public interface MediaService {
	void createMedia(MediaRequestDto mediaRequestDto);

	void updateMedia(MediaUpdateDto mediaUpdateDto);

	void deleteMedia(MediaDeleteDto mediaDeleteDto);

	MediaResponseDto readMedia(String mediaCode);

	List<MediaResponseDto> readMediaList(String userUuid);
}
