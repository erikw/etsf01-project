#!/bin/bash
# A static configuration for project paramters. Edit the assignments below. The integer corresponds to the position in the sets in the comments. The first element in the set has index 1.
declare parameters
parameters[${#parameters[*]}]=1		# RELY, {"Low", "Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# DATA, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=0		# CPLX, {"Low","Nominal","High","Very_High","Extra_High"}
parameters[${#parameters[*]}]=1		# TIME, {"Nominal","High","Very_High","Extra_High"}
parameters[${#parameters[*]}]=2		# STOR, {"Nominal","High","Very_High","Extra_High"}
parameters[${#parameters[*]}]=2		# VIRT, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# TURN, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=0		# ACAP, {"Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# AEXP, {"Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# PCAP, {"Nominal","High","Very_High"}
parameters[${#parameters[*]}]=1		# VEXP, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=1		# LEXP, {"Very_Low","Low","Nominal","High"}
parameters[${#parameters[*]}]=1		# MODP, {"Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=2		# TOOL, {"Very_Low","Low","Nominal","High","Very_High"}
parameters[${#parameters[*]}]=2		# SCED, {"Low","Nominal","High"}
parameters[${#parameters[*]}]=100	# LOC, numeric
#parameters[${#parameters[*]}]=0	# USER1
#parameters[${#parameters[*]}]=0	# USER2
#parameters[${#parameters[*]}]=0	# USER3
parameters[${#parameters[*]}]=0.35	# Threshold, numeric [0, 1]

for parameter in ${parameters[*]};
do
	 echo ${parameter}
done;
