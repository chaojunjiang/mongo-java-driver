/*
 * Copyright 2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.client.model

import spock.lang.Specification

class InsertManyOptionsSpecification extends Specification {
    def 'should have the expected defaults'() {
        when:
        def options = new InsertManyOptions()

        then:
        options.isOrdered()
        options.getBypassDocumentValidation() == null
    }

    def 'should set ordered'() {
        expect:
        new InsertManyOptions().ordered(ordered).isOrdered() == ordered

        where:
        ordered << [true, false]
    }

    def 'should set bypassDocumentValidation'() {
        expect:
        new InsertManyOptions().bypassDocumentValidation(bypassValidation).getBypassDocumentValidation() == bypassValidation

        where:
        bypassValidation << [null, true, false]
    }
}
