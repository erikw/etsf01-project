#!/bin/sh
# A static configuration for project paramters. Edit the assignments below. The integer corresponds to the position in the sets in the comments. The first element in the set has index 1.
declare -A parameters

parameters+=(["RELY"]=1)	# {"Nominal","Very_High","High","Low"}
parameters+=(["DATA"]=1)	# {"High","Low","Nominal","Very_High"}
parameters+=(["CPLX"]=1)	# {"Very_High","High","Nominal","Extra_High","Low"}
parameters+=(["TIME"]=1)	# {"Nominal","Very_High","High","Extra_High"}
parameters+=(["STOR"]=1)	# {"Nominal","Very_High","High","Extra_High"}
parameters+=(["TURN"]=1)	# {"Nominal","High","Low"}
parameters+=(["ACAP"]=1)	# {"High","Very_High","Nominal"}
parameters+=(["AEXP"]=1)	# {"Nominal","Very_High","High"}
parameters+=(["PCAP"]=1)	# {"Very_High","High","Nominal"}
parameters+=(["VEXP"]=1)	# {"Low","Nominal","High"}
parameters+=(["LEXP"]=1)	# {"Nominal","High","Very_Low","Low"}
parameters+=(["MODP"]=1)	# {"High","Nominal","Very_High","Low"}
parameters+=(["TOOL"]=1)	# {"Nominal","High","Very_High","Very_Low","Low"}
parameters+=(["SCED"]=1)	# {"Low","Nominal","High"}
parameters+=(["LOC"]=1 )	# numeric
parameters+=(["ACT_EFFORT"]=1)	# numeric

for parameter in "${!parameters[@]}";
do
	 echo "${parameters[$parameter]}"
done;
