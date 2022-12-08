package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateNewBoardRequest {
	private String id;
	@JsonProperty("prefs_background_url")
	private String prefsBackgroundUrl;
	@JsonProperty("prefs_selfJoin")
	private Boolean prefsSelfJoin;
	private String name;
	private String idOrganization;
	private Boolean defaultLists;
	@JsonProperty("prefs_permissionLevel")
	private String prefsPermissionLevel;
	private String token;

}