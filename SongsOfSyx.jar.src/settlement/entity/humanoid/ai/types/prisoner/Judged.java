/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.court.CourtStation;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ class Judged
/*     */   extends AIPLAN.PLANRES {
/*  17 */   private static CharSequence ¤¤verb = "Pleading case in court"; private final AIPLAN.PLANRES.Resumer walk;
/*     */   static {
/*  19 */     D.ts(Judged.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer ready; private final AIPLAN.PLANRES.Resumer freed;
/*     */   public Judged() {
/*  23 */     super("prisJudged");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  42 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  43 */           if (s != null) {
/*  44 */             return s;
/*     */           }
/*  46 */           Judged.this.cancel(a, d);
/*  47 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  52 */           return Judged.this.ready.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  57 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  67 */     this.ready = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  71 */           CourtStation s = (SETT.ROOMS()).COURT.executionSpot((COORDINATE)d.planTile);
/*  72 */           s.criminalUse();
/*  73 */           d.planByte1 = (byte)TIME.hours().bitCurrent();
/*  74 */           d.planByte2 = (byte)(TIME.days().bitCurrent() & 0xF);
/*  75 */           a.speed.setDirCurrent(s.criminalDir());
/*  76 */           d.planByte3 = 8;
/*  77 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  82 */           CourtStation s = (SETT.ROOMS()).COURT.executionSpot((COORDINATE)d.planTile);
/*  83 */           if (s.criminalIsBeeingHeard()) {
/*  84 */             d.planByte3 = (byte)(d.planByte3 - 1); if (d.planByte3 <= 0) {
/*  85 */               PrisonerData.self.judged.set(d, 1);
/*  86 */               Judged.this.cancel(a, d);
/*     */               
/*  88 */               if (RND.rFloat() < 0.2D) {
/*  89 */                 return Judged.this.freed.set(a, d);
/*     */               }
/*     */               
/*  92 */               return null;
/*     */             } 
/*     */             
/*  95 */             if (RND.oneIn(4)) {
/*  96 */               a.speed.setDirCurrent(s.criminalDir().next(RND.rInt0(2)));
/*  97 */               return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*     */             } 
/*  99 */             return (AI.SUBS()).single.activate(a, d, RND.rBoolean() ? (AI.STATES()).anima.box : (AI.STATES()).anima.wave, (1.0F + RND.rFloat() * 4.0F));
/*     */           } 
/*     */           
/* 102 */           if (Math.abs(d.planByte2 - (TIME.days().bitCurrent() & 0xF)) > 1) {
/* 103 */             if (s != null)
/* 104 */               s.criminalClear(); 
/* 105 */             return null;
/*     */           } 
/* 107 */           a.speed.setDirCurrent(a.speed.dir().next(RND.rInt0(2)));
/* 108 */           return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 115 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 126 */     this.freed = ResFree.make(this);
/*     */   }
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 130 */     CourtStation s = (SETT.ROOMS()).COURT.executionSpot((COORDINATE)d.planTile);
/* 131 */     if (s != null)
/* 132 */       s.criminalClear(); 
/* 133 */     super.cancel(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 138 */     if (getResumer(d) == this.freed)
/* 139 */       return true; 
/* 140 */     CourtStation s = (SETT.ROOMS()).COURT.executionSpot((COORDINATE)d.planTile);
/* 141 */     if (s != null && s.criminalReserved())
/* 142 */       return super.shouldContinue(a, d); 
/* 143 */     return false;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     CourtStation s = (SETT.ROOMS()).COURT.exectuionReserve();
/*     */     if (s == null)
/*     */       return null; 
/*     */     d.planTile.set(s.cooCriminal());
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Judged.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */