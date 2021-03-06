/*
 * Copyright 2019. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ms.dew.auth.dto.management

import com.ecfront.dew.common.$
import javax.validation.constraints.NotNull
import ms.dew.auth.domain.Tenant
import ms.dew.auth.dto.common.StatusDTO
import ms.dew.auth.helper.CommonConverter

import scala.beans.BeanProperty

class TenantModifyReq extends StatusDTO {

  @BeanProperty
  @NotNull()
  var name: String = _

}

object TenantModifyReq {

  def convert(ori: TenantModifyReq, dest: Tenant): Tenant = {
    val id = dest.id
    val tmp = CommonConverter.convert[Tenant](ori)
    $.bean.copyProperties(dest, tmp)
    dest.id = id
    dest
  }

}