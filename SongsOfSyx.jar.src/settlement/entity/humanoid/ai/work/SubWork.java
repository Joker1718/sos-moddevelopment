/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class SubWork
/*     */ {
/*     */   private static final String sworking = "working";
/*     */   
/*     */   public static abstract class SubWorkTool
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public SubWorkTool(String key) {
/*  22 */       super(key);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/*  27 */       throw new RuntimeException();
/*     */     }
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d, SETT_JOB j) {
/*  31 */       AISUB.AISubActivation k = activate(a, d, (AI.STATES()).anima.toolSlam.activate(a, d));
/*  32 */       int iters = (int)(j.jobPerformTime(a) / ((AI.STATES()).anima.toolSlam.time + (AI.STATES()).anima.toolBack.time));
/*  33 */       if (j.jobPerformTime(a) - iters > 0.0D)
/*  34 */         iters++; 
/*  35 */       iters *= 2;
/*  36 */       iters &= 0xFFFFFFFE;
/*  37 */       if (iters > 255)
/*     */       {
/*  39 */         iters = 255;
/*     */       }
/*  41 */       if (iters <= 0) {
/*  42 */         GAME.Notify("bah " + iters + " " + j.jobPerformTime(a) + " " + String.valueOf(j.jobCoo()));
/*  43 */         d.subByte = 2;
/*     */       } 
/*     */       
/*  46 */       d.subByte = (byte)iters;
/*     */       
/*  48 */       return k;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected AISTATE resume(Humanoid a, AIManager d) {
/*  55 */       d.subByte = (byte)(d.subByte - 1);
/*     */       
/*  57 */       int s = d.subByte & 0xFF;
/*  58 */       if (s == 0)
/*  59 */         return null; 
/*  60 */       if ((s & 0x1) == 1) {
/*  61 */         SETT_JOB j = getJob(a, d);
/*  62 */         if (j == null)
/*  63 */           return null; 
/*  64 */         if (j.jobSound() != null) {
/*  65 */           if (a == null) {
/*  66 */             System.err.println("a");
/*  67 */           } else if (a.physics == null) {
/*  68 */             System.err.println("phy");
/*  69 */           } else if (a.physics.body() == null) {
/*  70 */             System.err.println("2");
/*  71 */           }  j.jobSound().rnd(a);
/*     */         } 
/*  73 */         return (AI.STATES()).anima.toolBack.activate(a, d);
/*     */       } 
/*  75 */       return (AI.STATES()).anima.toolSlam.activate(a, d);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected CharSequence name(Humanoid a, AIManager d) {
/*  81 */       if (getJob(a, d) == null) {
/*  82 */         return "working";
/*     */       }
/*  84 */       return getJob(a, d).jobName();
/*     */     }
/*     */     
/*     */     protected abstract SETT_JOB getJob(Humanoid param1Humanoid, AIManager param1AIManager);
/*     */   }
/*     */   
/*     */   public static abstract class SubWorkHands
/*     */     extends AISUB.Simple
/*     */   {
/*  93 */     private final AISTATES.Animation ani = (AI.STATES()).anima.box;
/*     */     
/*     */     public SubWorkHands(String key) {
/*  96 */       super(key);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 101 */       throw new RuntimeException();
/*     */     }
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d, SETT_JOB j) {
/* 105 */       AISUB.AISubActivation k = activate(a, d, this.ani.resume(a, d, 5.0D));
/* 106 */       int iters = (int)Math.ceil(j.jobPerformTime(a) / 5.0D);
/* 107 */       iters--;
/* 108 */       d.subByte = (byte)iters;
/* 109 */       if (d.subByte < 0)
/* 110 */         throw new RuntimeException("" + d.subByte + " " + d.subByte); 
/* 111 */       return k;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected AISTATE resume(Humanoid a, AIManager d) {
/* 117 */       d.subByte = (byte)(d.subByte - 1);
/*     */       
/* 119 */       if (d.subByte < 0) {
/* 120 */         return null;
/*     */       }
/* 122 */       SETT_JOB j = getJob(a, d);
/* 123 */       if (j == null)
/* 124 */         return null; 
/* 125 */       if (j.jobSound() != null)
/* 126 */         j.jobSound().rnd(a); 
/* 127 */       if (d.subByte == 0) {
/* 128 */         double t = j.jobPerformTime(a) % 5.0D;
/* 129 */         if (t == 0.0D)
/* 130 */           return this.ani.resume(a, d, 5.0D); 
/* 131 */         return this.ani.resume(a, d, t);
/*     */       } 
/*     */       
/* 134 */       return this.ani.resume(a, d, 5.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     protected CharSequence name(Humanoid a, AIManager d) {
/* 139 */       if (getJob(a, d) == null) {
/* 140 */         return "working";
/*     */       }
/* 142 */       return getJob(a, d).jobName();
/*     */     }
/*     */     
/*     */     protected abstract SETT_JOB getJob(Humanoid param1Humanoid, AIManager param1AIManager);
/*     */   }
/*     */   
/*     */   public static abstract class SubWorkThink
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public SubWorkThink(String key) {
/* 152 */       super(key);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 157 */       throw new RuntimeException();
/*     */     }
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d, SETT_JOB j) {
/* 161 */       AISUB.AISubActivation k = activate(a, d, resume(a, d, 5.0D));
/* 162 */       int iters = (int)Math.ceil(j.jobPerformTime(a) / 5.0D);
/* 163 */       iters--;
/* 164 */       d.subByte = (byte)iters;
/* 165 */       if (d.subByte < 0)
/* 166 */         throw new RuntimeException("" + d.subByte); 
/* 167 */       return k;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected AISTATE resume(Humanoid a, AIManager d) {
/* 173 */       d.subByte = (byte)(d.subByte - 1);
/*     */       
/* 175 */       if (d.subByte < 0) {
/* 176 */         return null;
/*     */       }
/* 178 */       SETT_JOB j = getJob(a, d);
/* 179 */       if (j == null)
/* 180 */         return null; 
/* 181 */       if (j.jobSound() != null)
/* 182 */         j.jobSound().rnd(a); 
/* 183 */       if (d.subByte == 0) {
/* 184 */         double t = j.jobPerformTime(a) % 5.0D;
/* 185 */         if (t == 0.0D)
/* 186 */           return resume(a, d, 5.0D); 
/* 187 */         return resume(a, d, t);
/*     */       } 
/*     */       
/* 190 */       return resume(a, d, 5.0D);
/*     */     }
/*     */     
/*     */     private AISTATE resume(Humanoid a, AIManager d, double time) {
/* 194 */       if (RND.oneIn(8)) {
/* 195 */         a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/* 196 */         return (AI.STATES()).anima.stand.activate(a, d, time);
/*     */       } 
/* 198 */       a.speed.setDirCurrent(DIR.get(a.tc(), getJob(a, d).jobCoo()));
/* 199 */       if (RND.rBoolean()) {
/* 200 */         return (AI.STATES()).anima.fistRight.resume(a, d, time);
/*     */       }
/* 202 */       return (AI.STATES()).anima.stand.activate(a, d, time);
/*     */     }
/*     */ 
/*     */     
/*     */     protected CharSequence name(Humanoid a, AIManager d) {
/* 207 */       if (getJob(a, d) == null) {
/* 208 */         return "working";
/*     */       }
/* 210 */       return getJob(a, d).jobName();
/*     */     }
/*     */     
/*     */     protected abstract SETT_JOB getJob(Humanoid param1Humanoid, AIManager param1AIManager);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\SubWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */