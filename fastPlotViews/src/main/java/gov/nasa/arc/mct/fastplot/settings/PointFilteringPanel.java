/*******************************************************************************
 * Mission Control Technologies, Copyright (c) 2009-2012, United States Government
 * as represented by the Administrator of the National Aeronautics and Space 
 * Administration. All rights reserved.
 *
 * The MCT platform is licensed under the Apache License, Version 2.0 (the 
 * "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations under 
 * the License.
 *
 * MCT includes source code licensed under additional open source licenses. See 
 * the MCT Open Source Licenses file included with this distribution or the About 
 * MCT Licenses dialog available at runtime from the MCT Help menu for additional 
 * information. 
 *******************************************************************************/
package gov.nasa.arc.mct.fastplot.settings;

import gov.nasa.arc.mct.components.FeedFilterProvider.FeedFilterEditor;
import gov.nasa.arc.mct.fastplot.bridge.PlotConstants;
import gov.nasa.arc.mct.fastplot.settings.controls.PlotSettingsCheckBox;
import gov.nasa.arc.mct.fastplot.settings.controls.PlotSettingsFilterPanel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JComponent;


public class PointFilteringPanel extends PlotSettingsPanel {
	private static final long serialVersionUID = 3251500488878359440L;

	public PointFilteringPanel(FeedFilterEditor filterEditor) {
		setLayout(new BorderLayout());
		
		PlotSettingsPanel topPanel = new PlotSettingsPanel();
		topPanel.setLayout(new BorderLayout());
		
		topPanel.add(new PlotSettingsCheckBox("Enable point filtering") {
			private static final long serialVersionUID = 6562191505425407092L;

			@Override
			public boolean getFrom(PlotConfiguration settings) {
				Boolean result = settings.getExtension(PlotConstants.FILTER_ENABLED, Boolean.class);				
				return result != null ? result : false;
			}

			@Override
			public void populate(PlotConfiguration settings) {
				settings.setExtension(PlotConstants.FILTER_ENABLED, isSelected());
			}
			
		}, BorderLayout.WEST);
		
		add(topPanel, BorderLayout.NORTH);
		add(new PlotSettingsFilterPanel(filterEditor), BorderLayout.CENTER);

	}
	
}
