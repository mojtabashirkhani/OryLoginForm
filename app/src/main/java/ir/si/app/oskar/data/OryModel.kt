package ir.si.app.oskar.data

import com.google.gson.annotations.SerializedName

data class OryModel(
    @SerializedName("id") var id: String? = null,
    @SerializedName("organization_id") var organizationId: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("expires_at") var expiresAt: String? = null,
    @SerializedName("issued_at") var issuedAt: String? = null,
    @SerializedName("request_url") var requestUrl: String? = null,
    @SerializedName("ui") var ui: Ui? = Ui(),
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("refresh") var refresh: Boolean? = null,
    @SerializedName("requested_aal") var requestedAal: String? = null,
    @SerializedName("state") var state: String? = null
)

data class Attributes(

    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("value") var value: String? = null,
    @SerializedName("required") var required: Boolean? = null,
    @SerializedName("disabled") var disabled: Boolean? = null,
    @SerializedName("node_type") var nodeType: String? = null

)


data class Meta(val name: String? = null)

data class Nodes(

    @SerializedName("type") var type: String? = null,
    @SerializedName("group") var group: String? = null,
    @SerializedName("attributes") var attributes: Attributes? = Attributes(),
    @SerializedName("messages") var messages: ArrayList<String> = arrayListOf(),
    @SerializedName("meta") var meta: Meta? = Meta()

)

data class Ui(

    @SerializedName("action") var action: String? = null,
    @SerializedName("method") var method: String? = null,
    @SerializedName("nodes") var nodes: ArrayList<Nodes> = arrayListOf()

)