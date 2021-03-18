/*******************************************************************************
 * Copyright (c) 2017, 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/

package io.openliberty.sample.system;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.google.common.util.concurrent.RateLimiter;

@ApplicationScoped
public class SystemConfig {

  @Inject
  @ConfigProperty(name = "io_openliberty_sample_system_inMaintenance")
  Provider<Boolean> inMaintenance;


  public boolean isInMaintenance() {
    return inMaintenance.get();
  }
  
  public static final Double PERMITS_PER_SECONDS = 1.0;
  public static RateLimiter limiter = RateLimiter.create(PERMITS_PER_SECONDS);
  
}
