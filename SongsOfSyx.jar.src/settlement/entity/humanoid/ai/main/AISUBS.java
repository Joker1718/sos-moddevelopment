/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.subwalk.AISUB_walkTo;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AISUBS
/*     */ {
/*  20 */   public final Stand STAND = new Stand();
/*  21 */   public final Lay LAY = new Lay("subsLAy");
/*  22 */   public final AISUB_walkTo walkTo = new AISUB_walkTo();
/*  23 */   public final Work WORK = new Work();
/*  24 */   public final WorkHands WORK_HANDS = new WorkHands();
/*  25 */   public final AISUB failure = new AISUB.Simple("rethinking")
/*     */     {
/*     */       protected AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/*  29 */         if (!a.speed.isZero())
/*  30 */           return (AI.STATES()).STOP.activate(a, d); 
/*  31 */         d.subByte = (byte)(d.subByte + 1);
/*  32 */         if (d.subByte == 1)
/*  33 */           return (AI.STATES()).STAND.activate(a, d, (0.5F + RND.rFloat())); 
/*  34 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean isSuccessful(Humanoid a, AIManager d) {
/*  39 */         return false;
/*     */       }
/*     */     };
/*  42 */   public final Single single = new Single("subsSingle");
/*     */   
/*  44 */   public final AISUB.Simple DUMMY = new AISUB.Simple("DUMMY")
/*     */     {
/*     */       protected AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/*  48 */         return null;
/*     */       }
/*     */     };
/*     */   
/*     */   public static class Work
/*     */   {
/*  54 */     private final AISUB.Simple sub = new AISUB.Simple("working")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/*  58 */           if (!a.speed.isZero())
/*  59 */             return (AI.STATES()).STOP.activate(a, d); 
/*  60 */           if (d.subByte == 1) {
/*  61 */             d.subByte = (byte)(d.subByte + 1);
/*  62 */             return (AI.STATES()).WORK.state;
/*     */           } 
/*  64 */           if (d.subByte == 2) {
/*  65 */             d.subByte = (byte)(d.subByte + 1);
/*  66 */             return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */           } 
/*  68 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/*  73 */           if (d.subByte >= 2)
/*  74 */             return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D); 
/*  75 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d, double time) {
/*  81 */       AISUB.AISubActivation k = this.sub.activate(a, d, (AI.STATES()).WORK.activate(a, d, time));
/*  82 */       if (time > 0.0D) {
/*  83 */         d.subByte = 1;
/*     */       } else {
/*  85 */         d.subByte = 2;
/*  86 */       }  return k;
/*     */     }
/*     */     
/*     */     AISUB.AISubActivation activate(Humanoid a, AIManager d, AISTATES.Animation animation, double time) {
/*  90 */       AISUB.AISubActivation k = this.sub.activate(a, d);
/*  91 */       d.subByte = 1;
/*  92 */       animation.activate(a, d, time);
/*  93 */       return k;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class Throw
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public Throw(String key) {
/* 102 */       super(key);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected AISTATE resume(Humanoid a, AIManager d) {
/* 108 */       if (!a.speed.isZero())
/* 109 */         return (AI.STATES()).STOP.activate(a, d); 
/* 110 */       d.subByte = (byte)(d.subByte + 1);
/* 111 */       if (d.subByte == 1) {
/* 112 */         return (AI.STATES()).anima.throww.activate(a, d);
/*     */       }
/* 114 */       if (d.subByte == 2) {
/* 115 */         DIR dd = a.speed.dir();
/* 116 */         int sx = a.body().cX();
/* 117 */         int sy = a.body().cY();
/* 118 */         dd = dd.next(1);
/* 119 */         sx += dd.x() * 32 / 2;
/* 120 */         sy += dd.y() * 32 / 2;
/*     */         
/* 122 */         (SETT.THINGS()).rubbish.throww(sx, sy, destX(a, d), destY(a, d));
/* 123 */         return (AI.STATES()).anima.fistRight.activate(a, d, 2.0D);
/*     */       } 
/* 125 */       if (d.subByte == 3) {
/* 126 */         return (AI.STATES()).anima.stand.activate(a, d, 4.0D);
/*     */       }
/*     */       
/* 129 */       return null;
/*     */     }
/*     */     
/*     */     public abstract int destX(Humanoid param1Humanoid, AIManager param1AIManager);
/*     */     
/*     */     public abstract int destY(Humanoid param1Humanoid, AIManager param1AIManager);
/*     */   }
/*     */   
/*     */   public static class WorkHands
/*     */   {
/* 139 */     private final AISUB.Simple sub = new AISUB.Simple("workhands")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 143 */           if (!a.speed.isZero())
/* 144 */             return (AI.STATES()).STOP.activate(a, d); 
/* 145 */           if (d.subByte == 1) {
/* 146 */             d.subByte = (byte)(d.subByte + 1);
/* 147 */             return (AI.STATES()).anima.box.activate(a, d);
/*     */           } 
/* 149 */           if (d.subByte == 2) {
/* 150 */             d.subByte = (byte)(d.subByte + 1);
/* 151 */             return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */           } 
/* 153 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 158 */           if (d.subByte >= 2)
/* 159 */             return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D); 
/* 160 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d, double time) {
/* 166 */       AISUB.AISubActivation k = this.sub.activate(a, d, (AI.STATES()).anima.box.activate(a, d, time));
/* 167 */       if (time > 0.0D) {
/* 168 */         d.subByte = 1;
/*     */       } else {
/* 170 */         d.subByte = 2;
/* 171 */       }  return k;
/*     */     }
/*     */     
/*     */     AISUB.AISubActivation activate(Humanoid a, AIManager d, AISTATES.Animation animation, double time) {
/* 175 */       AISUB.AISubActivation k = this.sub.activate(a, d);
/* 176 */       d.subByte = 1;
/* 177 */       animation.activate(a, d, time);
/* 178 */       return k;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Stand
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public Stand() {
/* 187 */       super("subsstanding");
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 192 */       return activateTime(a, d, 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activateRndDir(Humanoid a, AIManager d) {
/* 197 */       if (a.speed.isZero()) {
/* 198 */         a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/*     */       }
/* 200 */       activateTime(a, d, 4 + RND.rInt(4));
/* 201 */       return super.activate(a, d);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activateRndDir(Humanoid a, AIManager d, int seconds) {
/* 206 */       if (a.speed.isZero()) {
/* 207 */         a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/*     */       }
/* 209 */       activateTime(a, d, seconds);
/* 210 */       return super.activate(a, d);
/*     */     }
/*     */     
/*     */     public AISUB.AISubActivation activateTime(Humanoid a, AIManager d, int seconds) {
/* 214 */       d.subPathByte2 = (byte)seconds;
/* 215 */       return super.activate(a, d);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE resume(Humanoid a, AIManager d) {
/* 220 */       d.subByte = (byte)(d.subByte + 1);
/* 221 */       if (!a.speed.isZero())
/* 222 */         return (AI.STATES()).STOP.activate(a, d); 
/* 223 */       if (d.subByte == 1) {
/* 224 */         return (AI.STATES()).STAND.activate(a, d, d.subPathByte2);
/*     */       }
/* 226 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Single
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public Single(String key) {
/* 234 */       super(key);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 239 */       throw new RuntimeException();
/*     */     }
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d, AISTATES.Animation animation, double seconds) {
/* 243 */       return activate(a, d, animation.activate(a, d, seconds));
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE resume(Humanoid a, AIManager d) {
/* 248 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Lay
/*     */     extends AISUB.Simple
/*     */   {
/*     */     public Lay(String key) {
/* 256 */       super(key);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 261 */       return activateTime(a, d, 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISUB.AISubActivation activateRndDir(Humanoid a, AIManager d) {
/* 266 */       if (a.speed.isZero()) {
/* 267 */         a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/*     */       }
/* 269 */       return activateTime(a, d, 4 + RND.rInt(4));
/*     */     }
/*     */     
/*     */     public AISUB.AISubActivation activateTime(Humanoid a, AIManager d, int seconds) {
/* 273 */       d.subPathByte2 = (byte)seconds;
/* 274 */       return super.activate(a, d);
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE resume(Humanoid a, AIManager d) {
/* 279 */       d.subByte = (byte)(d.subByte + 1);
/* 280 */       if (!a.speed.isZero())
/* 281 */         return (AI.STATES()).STOP.activate(a, d); 
/* 282 */       if (d.subByte == 1) {
/* 283 */         return (AI.STATES()).LAY.activate(a, d, d.subPathByte2);
/*     */       }
/* 285 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 290 */   public final AISUB confused = new AISUB.Simple("subConfused")
/*     */     {
/*     */       public AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/* 294 */         if (!a.speed.isZero())
/* 295 */           return (AI.STATES()).STOP.activate(a, d); 
/* 296 */         d.subByte = (byte)(d.subByte + 1);
/* 297 */         if (d.subByte < 5) {
/* 298 */           a.speed.turn2Angle(RND.rInt(45));
/* 299 */           return (AI.STATES()).STAND.activate(a, d, 0.30000001192092896D);
/*     */         } 
/*     */         
/* 302 */         return null;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 307 */   public final AISUB desperate = new AISUB.Simple("SubDesperate")
/*     */     {
/*     */       
/*     */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */       {
/* 312 */         if (e.event == HEvent.COLLISION_TILE) {
/* 313 */           return true;
/*     */         }
/*     */         
/* 316 */         if (e.event == HEvent.COLLISION_SOFT) {
/* 317 */           d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 318 */           return true;
/*     */         } 
/*     */         
/* 321 */         if (e.event == HEvent.MEET_HARMLESS && 
/* 322 */           RND.oneIn(4) && e.other != null && d.planByte1 < 5) {
/* 323 */           d.planByte1 = (byte)(d.planByte1 + 1);
/* 324 */           d.overwrite(a, (AI.STATES()).RUN.activateFRom(a, d, 3.0F + RND.rFloat(3.0D), e.other));
/*     */         } 
/*     */         
/* 327 */         return super.event(a, d, e);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected AISTATE resume(Humanoid a, AIManager d) {
/* 335 */         d.subByte = (byte)(d.subByte + 1);
/* 336 */         if (d.subByte < 5) {
/* 337 */           return state(a, d);
/*     */         }
/*     */         
/* 340 */         return null;
/*     */       }
/*     */       
/*     */       AISTATE state(Humanoid a, AIManager d) {
/* 344 */         if (!a.speed.isZero())
/* 345 */           return (AI.STATES()).STOP.activate(a, d); 
/* 346 */         switch (RND.rInt(8)) {
/*     */           case 0:
/* 348 */             return (AI.STATES()).LAY.activate(a, d, (5.0F + RND.rFloat(5.0D)));
/*     */           case 1:
/* 350 */             return (AI.STATES()).anima.box.activate(a, d, (1.0F + RND.rFloat(5.0D)));
/*     */           case 2:
/* 352 */             return (AI.STATES()).anima.wave.activate(a, d, (1.0F + RND.rFloat(5.0D)));
/*     */           case 3:
/* 354 */             return (AI.STATES()).RUN.activateRND(a, d, 0.2F + RND.rFloat(1.0D));
/*     */         } 
/* 356 */         return (AI.STATES()).STAND.aDirRND(a, d, 0.1F + RND.rFloat(1.0D));
/*     */       }
/*     */ 
/*     */       
/*     */       protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 361 */         return state(a, d);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 367 */   final AISUB NONE = new AISUB("NONE")
/*     */     {
/*     */       AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/* 371 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 376 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 381 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       boolean isSuccessful(Humanoid a, AIManager d) {
/* 386 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       void cancel(Humanoid a, AIManager d) {}
/*     */ 
/*     */       
/* 393 */       private String name = "none";
/*     */ 
/*     */       
/*     */       CharSequence name(Humanoid a, AIManager d) {
/* 397 */         return this.name;
/*     */       }
/*     */ 
/*     */       
/*     */       public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 402 */         return 0.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 407 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 412 */   public final AISUB subSleep = new AISUB.Simple("subSleeping")
/*     */     {
/* 414 */       private final SoundRace sound = AUDIO.race("SLEEP");
/*     */ 
/*     */ 
/*     */       
/*     */       public AISTATE resume(Humanoid a, AIManager d) {
/* 419 */         switch (d.subByte) {
/*     */           case 0:
/* 421 */             d.subByte = 1;
/* 422 */             if (!a.speed.dir().isOrtho())
/* 423 */               a.speed.setRaw(a.speed.dir().next(RND.rInt0(1)), 0.0D); 
/* 424 */             this.sound.rnd(a);
/* 425 */             return (AI.STATES()).SLEEP.activate(a, d, 8.0F);
/*     */         } 
/* 427 */         return null;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */