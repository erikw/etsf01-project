#!/bin/bash
# A static configuration for project paramters. Edit the assignments below. The integer corresponds to the position in the sets in the comments. The first element in the set has index 1.
declare parameters

parameters[${#parameters[*]}]=1		# "RELY", {"Nominal","Very_High","High","Low"}
parameters[${#parameters[*]}]=2		# "DATA", {"High","Low","Nominal","Very_High"}
parameters[${#parameters[*]}]=1		# "CPLX", {"Very_High","High","Nominal","Extra_High","Low"}
parameters[${#parameters[*]}]=1		# "TIME", {"Nominal","Very_High","High","Extra_High"}
parameters[${#parameters[*]}]=1		# "STOR", {"Nominal","Very_High","High","Extra_High"}
parameters[${#parameters[*]}]=1		# "TURN", {"Nominal","High","Low"}
parameters[${#parameters[*]}]=1		# "ACAP", {"High","Very_High","Nominal"}
parameters[${#parameters[*]}]=1		# "AEXP", {"Nominal","Very_High","High"}
parameters[${#parameters[*]}]=1		# "PCAP", {"Very_High","High","Nominal"}
parameters[${#parameters[*]}]=1		# "VEXP", {"Low","Nominal","High"}
parameters[${#parameters[*]}]=1		# "LEXP", {"Nominal","High","Very_Low","Low"}
parameters[${#parameters[*]}]=1		# "MODP", {"High","Nominal","Very_High","Low"}
parameters[${#parameters[*]}]=1		# "TOOL", {"Nominal","High","Very_High","Very_Low","Low"}
parameters[${#parameters[*]}]=1		# "SCED", {"Low","Nominal","High"}
parameters[${#parameters[*]}]=100 	# "LOC", numeric
parameters[${#parameters[*]}]=20	# "ACT_EFFORT", numeric

for parameter in ${parameters[*]};
do
	 echo ${parameter}
done;
