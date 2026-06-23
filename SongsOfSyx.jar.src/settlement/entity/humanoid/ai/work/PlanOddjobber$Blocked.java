/*      */ package settlement.entity.humanoid.ai.work;
/*      */ 
/*      */ import init.resources.RESOURCE;
/*      */ import init.resources.RESOURCES;
/*      */ import settlement.entity.humanoid.Humanoid;
/*      */ import settlement.entity.humanoid.ai.main.AI;
/*      */ import settlement.entity.humanoid.ai.main.AIManager;
/*      */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*      */ import settlement.entity.humanoid.ai.main.AISUB;
/*      */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*      */ import settlement.job.BlockedJobs;
/*      */ import settlement.main.SETT;
/*      */ import settlement.misc.job.SETT_JOB;
/*      */ import snake2d.util.datatypes.COORDINATE;
/*      */ import snake2d.util.misc.CLAMP;
/*      */ import snake2d.util.sprite.text.Str;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ final class Blocked
/*      */ {
/*      */   private final AIPlanResourceMany fetch;
/*      */   
/*      */   private Blocked() {
/* 1086 */     this.fetch = new AIPlanResourceMany(paramPlanOddjobber, 32)
/*      */       {
/*      */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*      */         {
/* 1090 */           d.planByte1 = resource(a, d).bIndex();
/* 1091 */           return PlanOddjobber.Blocked.this.walk2Job.set(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public void cancel(Humanoid a, AIManager d) {
/* 1096 */           d.planByte1 = resource(a, d).bIndex();
/* 1097 */           PlanOddjobber.Blocked.this.cancel(a, d, resource(a, d));
/*      */         }
/*      */       };
/*      */     
/* 1101 */     this.walk2Job = new AIPLAN.PLANRES.Resumer(paramPlanOddjobber, PlanOddjobber.¤¤working)
/*      */       {
/*      */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*      */         {
/*      */           AISUB.AISubActivation s;
/* 1106 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1107 */           if (j == null) {
/* 1108 */             PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/* 1109 */             return null;
/*      */           } 
/*      */           
/* 1112 */           int dx = j.jobCoo().x();
/* 1113 */           int dy = j.jobCoo().y();
/*      */           
/* 1115 */           if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && 
/* 1116 */             a.physics.tileC().isSameAs((COORDINATE)d.path)) {
/* 1117 */             s = (AI.SUBS()).walkTo.path(a, d);
/*      */           } else {
/* 1119 */             s = (AI.SUBS()).walkTo.coo(a, d, dx, dy);
/*      */           } 
/*      */           
/* 1122 */           if (s == null) {
/* 1123 */             PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/* 1124 */             return null;
/*      */           } 
/* 1126 */           return s;
/*      */         }
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 1131 */           return PlanOddjobber.Blocked.this.work.set(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean con(Humanoid a, AIManager d) {
/* 1136 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1137 */           if (j == null || !j.jobReservedIs(PlanOddjobber.Blocked.this.resource(d))) {
/* 1138 */             return false;
/*      */           }
/* 1140 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public void can(Humanoid a, AIManager d) {
/* 1145 */           PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/*      */         }
/*      */ 
/*      */         
/*      */         public void name(Humanoid a, AIManager d, Str string) {
/* 1150 */           BlockedJobs.BlockedJob blockedJob = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1151 */           if (blockedJob == null || blockedJob.jobName() == null) {
/* 1152 */             super.name(a, d, string);
/*      */           } else {
/* 1154 */             string.add(blockedJob.jobName());
/*      */           } 
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/* 1161 */     this.work = new AIPLAN.PLANRES.Resumer(paramPlanOddjobber, PlanOddjobber.¤¤working)
/*      */       {
/* 1163 */         private SubWork.SubWorkTool sub = new SubWork.SubWorkTool("regularOddjobtool2")
/*      */           {
/*      */             public SETT_JOB getJob(Humanoid a, AIManager d)
/*      */             {
/* 1167 */               return (SETT_JOB)(SETT.JOBS()).blocked.getByRef(d.planTile.x());
/*      */             }
/*      */           };
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 1173 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1174 */           if (j.jobPerformTime(a) <= 0.0D) {
/* 1175 */             return res(a, d);
/*      */           }
/* 1177 */           j.jobStartPerforming();
/* 1178 */           return this.sub.activate(a, d, (SETT_JOB)j);
/*      */         }
/*      */ 
/*      */         
/*      */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 1183 */           BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1184 */           RESOURCE produced = null;
/* 1185 */           if (j.jobReservedIs(null)) {
/* 1186 */             produced = j.jobPerform(a, null, 0);
/* 1187 */           } else if (j.jobReservedIs(d.resourceCarried())) {
/* 1188 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 1189 */             produced = j.jobPerform(a, d.resourceCarried(), am);
/* 1190 */             d.resourceAInc(-am);
/* 1191 */             d.resourceDrop(a);
/* 1192 */             d.planByte1 = -1;
/*      */           } else {
/* 1194 */             PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/* 1195 */             return null;
/*      */           } 
/* 1197 */           if (produced != null) {
/* 1198 */             (SETT.THINGS()).resources.create(a.physics.tileC(), produced, 1);
/*      */           }
/*      */           
/* 1201 */           if ((AI.modules()).work.moduleCanContinue(a, d)) {
/* 1202 */             j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1203 */             if (j != null && j.jobReserveCanBe()) {
/* 1204 */               if (j.jobResourcesNeeded(a) == 0) {
/* 1205 */                 j.jobReserve(null);
/* 1206 */               } else if (d.resourceCarried() != null && (d.resourceCarried()).bit.has(j.jobResourceBitToFetch())) {
/* 1207 */                 j.jobReserve(d.resourceCarried());
/*      */               } else {
/* 1209 */                 return null;
/* 1210 */               }  return PlanOddjobber.Blocked.this.walk2Job.set(a, d);
/*      */             } 
/*      */           } 
/*      */           
/* 1214 */           return null;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean con(Humanoid a, AIManager d) {
/* 1221 */           return PlanOddjobber.Blocked.this.walk2Job.con(a, d);
/*      */         }
/*      */ 
/*      */         
/*      */         public void can(Humanoid a, AIManager d) {
/* 1226 */           PlanOddjobber.Blocked.this.cancel(a, d, PlanOddjobber.Blocked.this.resource(d));
/*      */         }
/*      */         
/*      */         public void name(Humanoid a, AIManager d, Str string)
/*      */         {
/* 1231 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 1232 */           if (j == null || j.jobName() == null) {
/* 1233 */             super.name(a, d, string);
/*      */           } else {
/* 1235 */             string.add(j.jobName());
/*      */           } 
/*      */         }
/*      */       };
/*      */   } private final AIPLAN.PLANRES.Resumer walk2Job; private final AIPLAN.PLANRES.Resumer work;
/*      */   private void cancel(Humanoid a, AIManager d, RESOURCE res) {
/* 1241 */     BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.getByRef(d.planTile.x());
/* 1242 */     if (j != null) {
/* 1243 */       if (j.jobReservedIs(res))
/* 1244 */         j.jobReserveCancel(res); 
/* 1245 */       if (j.jobReservedIs(null)) {
/* 1246 */         j.jobReserveCancel(null);
/*      */       }
/*      */     } 
/* 1249 */     d.resourceDrop(a);
/*      */   }
/*      */   
/*      */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*      */     BlockedJobs.BlockedJob j = (SETT.JOBS()).blocked.next();
/*      */     if (j == null)
/*      */       return null; 
/*      */     d.planTile.xSet(j.ID);
/*      */     d.planByte1 = -1;
/*      */     d.resourceDrop(a);
/*      */     if (j.jobResourceBitToFetch() != null) {
/*      */       AISUB.AISubActivation s = this.fetch.activate(a, d, j.jobResourceBitToFetch(), CLAMP.i(j.jobResourcesNeeded(a), 0, WorkAbs.maxCarry), 2147483647, true, true);
/*      */       if (s != null) {
/*      */         j.jobReserve(this.fetch.resource(a, d));
/*      */         return s;
/*      */       } 
/*      */       return null;
/*      */     } 
/*      */     j.jobReserve(null);
/*      */     return this.walk2Job.set(a, d);
/*      */   }
/*      */   
/*      */   private RESOURCE resource(AIManager d) {
/*      */     return (d.planByte1 >= 0) ? (RESOURCE)RESOURCES.ALL().get(d.planByte1) : null;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddjobber$Blocked.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */