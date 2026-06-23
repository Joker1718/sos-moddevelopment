/*     */ package settlement.entity.humanoid.ai.crime;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIMES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Murder extends AIPLAN.PLANRES {
/*     */   final AIModule_Crime m;
/*  19 */   private static CharSequence ¤¤verb = "¤Murdering"; private final AIPLAN.PLANRES.Resumer go;
/*     */   
/*     */   static {
/*  22 */     D.ts(Murder.class);
/*     */   }
/*     */   
/*     */   private final AIPLAN.PLANRES.Resumer murder;
/*     */   
/*     */   public Murder(String key, AIModule_Crime m) {
/*  28 */     super(key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     this.go = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  42 */           if (d.planByte1 == 5)
/*  43 */             return null; 
/*  44 */           d.planByte1 = (byte)(d.planByte1 + 1);
/*  45 */           Humanoid h = (SETT.PATH()).finders.otherHumanoid.find(a, 100);
/*  46 */           if (h != null)
/*     */           {
/*  48 */             return (AI.SUBS()).walkTo.follow(a, d, (ENTITY)h, false, (byte)100);
/*     */           }
/*  50 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  57 */           if ((AI.SUBS()).walkTo.followSucess(a, d))
/*  58 */             return Murder.this.murder.set(a, d); 
/*  59 */           return set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  64 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  75 */           if (e.event == HEvent.MEET_HARMLESS) {
/*  76 */             ENTITY ee = SETT.ENTITIES().getByID(d.planObject);
/*  77 */             if (ee != null && ee instanceof Humanoid && ee == e.other) {
/*  78 */               Murder.this.m.commitCrime(a, d, true, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu()));
/*  79 */               d.overwrite(a, Murder.this.murder.set(a, d));
/*  80 */               return true;
/*     */             } 
/*     */           } 
/*  83 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/*  87 */     this.murder = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  91 */           ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/*  92 */           if (e == null)
/*  93 */             return null; 
/*  94 */           a.speed.turn2(a.body(), e.body());
/*  95 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword_out, (AI.STATES()).anima.sword_out.time);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 100 */           ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 101 */           if (e == null)
/* 102 */             return null; 
/* 103 */           if (e instanceof Humanoid) {
/* 104 */             Humanoid h = (Humanoid)e;
/* 105 */             double damage = RND.rFloat() * 0.99D;
/* 106 */             h.inflictDamage(damage, CAUSE_LEAVES.MURDER());
/* 107 */             AIModule_Crime.notify(a);
/* 108 */             if (h.isRemoved())
/* 109 */               return Murder.this.cool_down.set(a, d); 
/* 110 */             return Murder.this.chase.set(a, d);
/*     */           } 
/*     */           
/* 113 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 118 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 128 */     this.cool_down = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 132 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword, 4.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 137 */           AIModule_Crime.notify(a);
/* 138 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 143 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 153 */     this.chase = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 157 */           AIModule_Crime.notify(a);
/* 158 */           return (AI.SUBS()).walkTo.follow(a, d, SETT.ENTITIES().getByID(d.planObject), true, (byte)5);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 163 */           if ((AI.SUBS()).walkTo.followSucess(a, d))
/* 164 */             return Murder.this.murder.set(a, d); 
/* 165 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 170 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */         {
/* 181 */           if (e.event == HEvent.MEET_HARMLESS) {
/* 182 */             ENTITY ee = SETT.ENTITIES().getByID(d.planObject);
/* 183 */             if (ee != null && ee instanceof Humanoid && ee == e.other) {
/*     */               
/* 185 */               d.overwrite(a, Murder.this.murder.set(a, d));
/* 186 */               return true;
/*     */             } 
/*     */           } 
/* 189 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     this.m = m;
/*     */   } private final AIPLAN.PLANRES.Resumer cool_down; private final AIPLAN.PLANRES.Resumer chase;
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 195 */     if (e.event == HEvent.NOTIFY_CRIME)
/* 196 */       return false; 
/* 197 */     return super.event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 202 */     super.cancel(a, d);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     d.planByte1 = 0;
/*     */     return this.go.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Murder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */