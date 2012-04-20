#!/bin/bash
# A static configuration for project paramters. Edit the assignments below. The integer corresponds to the position in the sets in the comments. The first element in the set has index 1.
declare parameters

parameters[${#parameters[*]}]=0		# RELY, {"Nominal","Very_High","High","Low"}
parameters[${#parameters[*]}]=1		# DATA, {"High","Low","Nominal","Very_High"}
parameters[${#parameters[*]}]=2		# CPLX, {"Very_High","High","Nominal","Extra_High","Low"}
parameters[${#parameters[*]}]=0		# TIME, {"Nominal","Very_High","High","Extra_High"}
parameters[${#parameters[*]}]=0		# STOR, {"Nominal","Very_High","High","Extra_High"}
parameters[${#parameters[*]}]=0		# VIRT, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# TURN, {"Nominal","High","Low"}
parameters[${#parameters[*]}]=0		# ACAP, {"High","Very_High","Nominal"}
parameters[${#parameters[*]}]=0		# AEXP, {"Nominal","Very_High","High"}
parameters[${#parameters[*]}]=0		# PCAP, {"Very_High","High","Nominal"}
parameters[${#parameters[*]}]=0		# VEXP, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=0		# LEXP, {"Nominal","High","Very_Low","Low"}
parameters[${#parameters[*]}]=0		# MODP, {"High","Nominal","Very_High","Low"}
parameters[${#parameters[*]}]=0		# TOOL, {"Nominal","High","Very_High","Very_Low","Low"}
parameters[${#parameters[*]}]=0		# SCED, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=100 	# LOC, numeric
parameters[${#parameters[*]}]=20	# ACT_EFFORT, numeric
parameters[${#parameters[*]}]=70	# Threshold, numeric [0, 100]

for parameter in ${parameters[*]};
do
	 echo ${parameter}
done;
