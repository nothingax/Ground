/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.work.idworker;
/**
 * Program Name: Ground
 * <p>
 * Description: ID生成器异常
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2018/7/6 11:23 PM
 */
public class IDWorkerException extends BaseException {

  private static final long serialVersionUID = -329087741208425060L;

  public IDWorkerException() {
    super();
  }

  public IDWorkerException(String message) {
    super(message);
  }

  public IDWorkerException(String message, Throwable cause) {
    super(message, cause);
  }

  public IDWorkerException(Throwable cause) {
    super(cause);
  }
}
