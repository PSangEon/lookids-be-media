package lookids.media.media.dto.in;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookids.media.media.domain.Media;
import lookids.media.media.vo.in.MediaRequestVo;

@Getter
@NoArgsConstructor
public class MediaRequestDto {
	private String mediaType;
	private String mediaUrl;
	private Double latitude;
	private Double longitude;

	@Builder
	public MediaRequestDto(String mediaType, String mediaUrl, Double latitude, Double longitude) {
		this.mediaType = mediaType;
		this.mediaUrl = mediaUrl;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static MediaRequestDto toDto(MediaRequestVo mediaRequestVo) {
		return MediaRequestDto.builder()
			.mediaType(mediaRequestVo.getMediaType())
			.mediaUrl(mediaRequestVo.getMediaUrl())
			.latitude(mediaRequestVo.getLatitude())
			.longitude(mediaRequestVo.getLongitude())
			.build();
	}

	public Media toEntity() {
		return Media.builder()
			.mediaCode(UUID.randomUUID().toString())
			.mediaType(mediaType)
			.mediaUrl(mediaUrl)
			.latitude(latitude)
			.longitude(longitude)
			.state(true)
			.createAt(LocalDateTime.now())
			.build();
	}
}
