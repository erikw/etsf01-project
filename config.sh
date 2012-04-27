#!/bin/bash
# A static configuration for project paramters. Edit the assignments below. The integer corresponds to the position in the sets in the comments. The first element in the set has index 1.
declare parameters
parameters[${#parameters[*]}]=0		# RELY, {"Low", "Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# DATA, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# CPLX, {"Low","Nominal","High","Very_High","Extra_High"}
parameters[${#parameters[*]}]=0		# TIME, {"Nominal","High","Very_High","Extra_High"}
parameters[${#parameters[*]}]=0		# STOR, {"Nominal","High","Very_High","Extra_High"}
parameters[${#parameters[*]}]=0		# VIRT, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# TURN, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=0		# ACAP, {"Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# AEXP, {"Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# PCAP, {"Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# VEXP, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=0		# LEXP, {"Very_Low","Low","Nominal","High"}
parameters[${#parameters[*]}]=0		# MODP, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# TOOL, {"Very_Low","Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# SCED, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=100	# LOC, numeric
parameters[${#parameters[*]}]=20	# ACT_EFFORT, numeric
parameters[${#parameters[*]}]=50	# Threshold, numeric [0, 100]

for parameter in ${parameters[*]};
do
	 echo ${parameter}
done;
