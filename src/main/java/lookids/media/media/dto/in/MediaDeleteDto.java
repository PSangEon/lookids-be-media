package lookids.media.media.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.media.media.domain.Media;
import lookids.media.media.vo.in.MediaDeleteVo;

@Getter
@NoArgsConstructor
public class MediaDeleteDto {
	private String mediaCode;

	@Builder
	public MediaDeleteDto(String mediaCode) {
		this.mediaCode = mediaCode;
	}

	public static MediaDeleteDto toDto(MediaDeleteVo mediaDeleteVo) {
		return MediaDeleteDto.builder().mediaCode(mediaDeleteVo.getMediaCode()).build();
	}

	public Media toEntity(Media media) {
		return Media.builder()
			.id(media.getId())
			.userUuid(media.getUserUuid())
			.mediaCode(media.getMediaCode())
			.mediaType(media.getMediaType())
			.mediaUrl(media.getMediaUrl())
			.latitude(media.getLatitude())
			.longitude(media.getLongitude())
			.state(false)
			.createAt(media.getCreateAt())
			.build();
	}
}
