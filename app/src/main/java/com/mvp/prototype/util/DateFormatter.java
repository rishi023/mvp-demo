/*
 * +=======================================================================+
 * |                                                                       |
 * |          Copyright (C) 2015-16 Nomura Research Institute Ltd          |
 * |                          All Rights Reserved                          |
 * |                                                                       |
 * |    This document is the sole property of Nomura Research Institute    |
 * |    Ltd. No part of this document may be reproduced in any form or     |
 * |    by any means - electronic, mechanical, photocopying, recording     |
 * |    or otherwise - without the prior written permission of Nomura      |
 * |    Research Institute Ltd                                             |
 * |                                                                       |
 * |    Unless required by applicable law or agreed to in writing,         |
 * |    software distributed under the License is distributed on an        |
 * |    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,       |
 * |    either express or implied.                                         |
 * |                                                                       |
 * +=======================================================================+
 */
package com.mvp.prototype.util;

/**
 * Created by deor on 25-02-2016.
 */
public class DateFormatter {
    public static final String formatDate(String date) {
        return new StringBuilder(date).insert(4, "/").insert(7, "/").toString();
    }
}
