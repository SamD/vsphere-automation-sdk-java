/*
 * *******************************************************
 * Copyright VMware, Inc. 2020.  All Rights Reserved.
 * SPDX-License-Identifier: MIT
 * *******************************************************
 *
 * DISCLAIMER. THIS PROGRAM IS PROVIDED TO YOU "AS IS" WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, WHETHER ORAL OR WRITTEN,
 * EXPRESS OR IMPLIED. THE AUTHOR SPECIFICALLY DISCLAIMS ANY IMPLIED
 * WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE.
 */
package vmware.samples.appliance.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.Option;

import com.vmware.appliance.system.Uptime;
import vmware.samples.common.SamplesAbstractBase;

/**
 * Description:
 * 1. Demonstrates getting system uptime
 * Author: VMware, Inc. Sample Prerequisites: vCenter 6.7+
 */
public class UptimeSample extends SamplesAbstractBase {
    private Uptime uptimeService;

    protected void setup() throws Exception {
        this.uptimeService = vapiAuthHelper.getStubFactory().createStub(
            Uptime.class,
            sessionStubConfig);
    }

    protected void run() throws Exception {
        final double upTime = uptimeService.get();
        System.out.println("VC Uptime : " + upTime);
        System.out.println();


    }

    protected void cleanup() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        new UptimeSample().execute(args);
    }

    protected void parseArgs(String[] args) {
        List<Option> optionList = new ArrayList<Option>();
        super.parseArgs(optionList, args);
    }
}
