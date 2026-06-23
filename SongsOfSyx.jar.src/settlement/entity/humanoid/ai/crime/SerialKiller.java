/*     */ package settlement.entity.humanoid.ai.crime;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderRND;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class SerialKiller
/*     */   extends AIPLAN.PLANRES {
/*     */   public SerialKiller(String key) {
/*  23 */     super(key);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     this.go = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  49 */           if (SerialKiller.this.isVictim((ENTITY)d.otherEntity())) {
/*  50 */             return SerialKiller.this.leave.set(a, d);
/*     */           }
/*     */           
/*  53 */           d.planByte1 = (byte)(d.planByte1 + 1); if (d.planByte1 > 8) {
/*  54 */             return null;
/*     */           }
/*  56 */           if ((SETT.PATH().finders()).randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64, SFinderRND.otherPeople)) {
/*  57 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           }
/*  59 */           return SerialKiller.this.stand.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  64 */           return SerialKiller.this.stand.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  69 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  81 */     this.stand = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  85 */           d.planByte2 = (byte)(6 + RND.rInt(8));
/*  86 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  91 */           d.planByte2 = (byte)(d.planByte2 - 1);
/*  92 */           if (d.planByte2 < 0) {
/*  93 */             return SerialKiller.this.go.set(a, d);
/*     */           }
/*  95 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 2 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 100 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 110 */     this.leave = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 114 */           if ((SETT.PATH().finders()).randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64, SFinderRND.noPeople)) {
/* 115 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           }
/* 117 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 2 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 122 */           if (!SerialKiller.this.isVictim((ENTITY)d.otherEntity())) {
/* 123 */             return null;
/*     */           }
/* 125 */           if (VIEW.s().getWindow().zoomout() <= 1 && VIEW.s().getWindow().pixels().touches((BODY_HOLDER)d.otherEntity())) {
/* 126 */             return null;
/*     */           }
/* 128 */           Humanoid v = d.otherEntity();
/* 129 */           int tx = v.tc().x();
/* 130 */           int ty = v.tc().y();
/* 131 */           v.kill(false, CAUSE_LEAVES.MURDER());
/* 132 */           ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)(SETT.THINGS()).corpses.tGet.get(tx, ty);
/* 133 */           if (c != null)
/* 134 */             (GAME.events()).killer.reportKill(c); 
/* 135 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 140 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤verb = "¤Walking around";
/*     */   private final AIPLAN.PLANRES.Resumer go;
/*     */   private final AIPLAN.PLANRES.Resumer stand;
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 152 */     if (d.planByte1 < 8 && e.event == HEvent.MEET_HARMLESS && 
/* 153 */       !isVictim((ENTITY)d.otherEntity()) && isVictim(e.other)) {
/* 154 */       d.otherEntitySet((Humanoid)e.other);
/*     */     }
/*     */     
/* 157 */     return super.event(a, d, e);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer leave; static { D.ts(SerialKiller.class); } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { d.planByte1 = 0; d.planByte2 = 0;
/*     */     d.otherEntitySet(null);
/* 161 */     return this.go.set(a, d); } private boolean isVictim(ENTITY e) { if (e instanceof Humanoid) {
/* 162 */       Humanoid o = (Humanoid)e;
/* 163 */       if ((o.indu().clas()).player && o.race() == (GAME.events()).killer.victimRace()) {
/* 164 */         return true;
/*     */       }
/*     */     } 
/* 167 */     return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 172 */     super.cancel(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\SerialKiller.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */