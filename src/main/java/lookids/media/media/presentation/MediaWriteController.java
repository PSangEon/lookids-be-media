package lookids.media.media.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lookids.media.common.entity.BaseResponse;
import lookids.media.common.entity.BaseResponseStatus;
import lookids.media.media.application.MediaService;
import lookids.media.media.dto.in.MediaDeleteDto;
import lookids.media.media.dto.in.MediaRequestDto;
import lookids.media.media.dto.in.MediaUpdateDto;
import lookids.media.media.vo.in.MediaDeleteVo;
import lookids.media.media.vo.in.MediaRequestVo;
import lookids.media.media.vo.in.MediaUpdateVo;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/write/media")
public class MediaWriteController {

	private final MediaService mediaService;

	@Operation(summary = "createMedia API", description = "createMedia API 입니다.")
	@PostMapping()
	public BaseResponse<Void> createMedia(@RequestBody MediaRequestVo mediaRequestVo) {
		mediaService.createMedia(MediaRequestDto.toDto(mediaRequestVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "updateMedia API", description = "updateMedia API 입니다.")
	@PutMapping()
	public BaseResponse<Void> updateMedia(@RequestBody MediaUpdateVo mediaUpdateVo) {
		mediaService.updateMedia(MediaUpdateDto.toDto(mediaUpdateVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

	@Operation(summary = "deleteMedia API", description = "deleteMedia API 입니다.")
	@PostMapping("/delete")
	public BaseResponse<Void> deleteMedia(@RequestBody MediaDeleteVo mediaDeleteVo) {
		mediaService.deleteMedia(MediaDeleteDto.toDto(mediaDeleteVo));
		return new BaseResponse<>(BaseResponseStatus.SUCCESS);
	}

}
