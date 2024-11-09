package lookids.media.media.dto.in;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.media.media.domain.Media;
import lookids.media.media.vo.in.MediaUpdateVo;

@Getter
@NoArgsConstructor
public class MediaUpdateDto {
	private String mediaCode;
	private Double latitude;
	private Double longitude;

	@Builder
	public MediaUpdateDto(String mediaCode, Double latitude, Double longitude) {
		this.mediaCode = mediaCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static MediaUpdateDto toDto(MediaUpdateVo mediaUpdateVo) {
		return MediaUpdateDto.builder()
			.mediaCode(mediaUpdateVo.getMediaCode())
			.latitude(mediaUpdateVo.getLatitude())
			.longitude(mediaUpdateVo.getLongitude())
			.build();
	}

	public Media toEntity(Media media) {
		return Media.builder()
			.id(media.getId())
			.userUuid(media.getUserUuid())
			.mediaCode(media.getMediaCode())
			.mediaType(media.getMediaType())
			.mediaUrl(media.getMediaUrl())
			.latitude(latitude)
			.longitude(longitude)
			.state(media.getState())
			.createAt(media.getCreateAt())
			.build();
	}
}
