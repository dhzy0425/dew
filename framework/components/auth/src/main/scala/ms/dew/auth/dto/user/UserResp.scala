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

package ms.dew.auth.dto.user

import com.ecfront.dew.common.Page
import ms.dew.auth.domain.Account
import ms.dew.auth.dto.common.SafeStatusDTO

import scala.beans.BeanProperty
import scala.collection.JavaConverters._


case class UserResp() extends SafeStatusDTO {

  @BeanProperty
  var id: String = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var roles: java.util.Map[String, String] = new java.util.HashMap()

  @BeanProperty
  var tenantId: String = _

}

object UserResp {

  implicit def convert(ori: Account): UserResp = {
    val userResp = UserResp()
    userResp.id = ori.id
    userResp.name = ori.name
    userResp.roles = ori.roles.asScala.map(role => role.id -> role.name).toMap.asJava
    userResp
  }

  implicit def convertPage(ori: org.springframework.data.domain.Page[Account]): Page[UserResp] = {
    Page.build(ori.getNumber(), ori.getNumberOfElements(), ori.getTotalElements,
      ori.getContent.asScala.map(convert).asJava)
  }

}





