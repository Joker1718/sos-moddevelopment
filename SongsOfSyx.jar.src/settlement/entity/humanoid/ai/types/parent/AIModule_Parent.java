/*     */ package settlement.entity.humanoid.ai.types.parent;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.types.child.AIModule_Child;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIModule_Parent
/*     */   extends AIModule
/*     */ {
/*  29 */   private static final INT_O.INT_OE<AIManager> nurishBit = (INT_O.INT_OE<AIManager>)new INT_O.INTWRAP(2, (AIModules.data()).byte2);
/*  30 */   private static final INT_O.INT_OE<AIManager> babyAge = (AIModules.data()).byte1;
/*     */   
/*  32 */   private static CharSequence ¤¤name = "Parenting";
/*  33 */   private static CharSequence ¤¤desc = "Need to nurture an infant";
/*  34 */   private static CharSequence ¤¤nurishing = "Nourishing Child";
/*     */   
/*     */   static {
/*  37 */     D.ts(AIModule_Parent.class);
/*     */   }
/*     */   private final AIPLAN nurish;
/*     */   
/*     */   public AIModule_Parent() {
/*  42 */     super((SPRITE)(UI.icons()).s.human, ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */     
/*  46 */     this.nurish = (AIPLAN)new AIPLAN.PLANRES("subParenting")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/*  50 */           if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/*  51 */             (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/*  52 */             return this.walking.set(a, d);
/*     */           } 
/*  54 */           d.planByte1 = (byte)(3 + RND.rInt(5));
/*  55 */           return this.start.set(a, d);
/*     */         }
/*     */         
/*  58 */         private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, AIModule_Parent.¤¤nurishing)
/*     */           {
/*     */             
/*     */             public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  63 */               return res(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  68 */               d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0) {
/*  69 */                 return null;
/*     */               }
/*     */               
/*  72 */               return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_BABY.aDirRND(a, d, 1.0F + RND.rFloat() * 5.0F));
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/*  77 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/*  86 */         private final AIPLAN.PLANRES.Resumer walking = new AIPLAN.PLANRES.Resumer(this, AIModule_Parent.¤¤nurishing)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  90 */               return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  95 */               if (AIModule_Parent.null.access$0(AIModule_Parent.null.this).moduleCanContinue(a, d)) {
/*  96 */                 if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path)) {
/*  97 */                   return AIModule_Parent.null.this.exit.set(a, d);
/*     */                 }
/*  99 */                 return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */               } 
/* 101 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 106 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 115 */         private final AIPLAN.PLANRES.Resumer exit = new AIPLAN.PLANRES.Resumer(this, AIModule_Parent.¤¤nurishing)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 119 */               if (d.path.isSuccessful()) {
/* 120 */                 return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */               }
/* 122 */               return AIModule_Parent.null.this.start.set(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 128 */               return AIModule_Parent.null.this.start.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 133 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 151 */     nurishBit.set(d, 0);
/* 152 */     return this.nurish.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean growChildUp(Humanoid a, AIManager d) {
/* 157 */     if (babyAge.get(d) >= (a.race()).physics.babyDays) {
/* 158 */       GrowUp(a);
/* 159 */       return true;
/*     */     } 
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public static void GrowUp(Humanoid a) {
/* 165 */     HTYPE hh = (a.indu().clas() == HCLASSES.SLAVE()) ? HTYPES.CHILD_SLAVE() : HTYPES.CHILD();
/*     */     
/* 167 */     Humanoid child = SETT.HUMANOIDS().create(a.race(), a.tc().x(), a.tc().y(), hh, CAUSE_ARRIVES.BORN());
/*     */     
/* 169 */     if (child != null) {
/*     */       
/* 171 */       (STATS.POP()).age.DAYS.set(child.indu(), (a.race()).physics.babyDays);
/* 172 */       (STATS.POP()).TYPE.NATIVE.set(child.indu());
/* 173 */       STATS.REL().setParent(child.indu(), a.indu());
/* 174 */       AIModule_Child.setGrowth(a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/* 182 */     nurishBit.set(d, 0);
/* 183 */     babyAge.set(d, 0);
/*     */   }
/*     */   
/*     */   public static int daysOld(Humanoid a) {
/* 187 */     AIManager d = (AIManager)a.ai();
/* 188 */     return babyAge.get(d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {
/* 193 */     if (RND.oneIn(4)) {
/* 194 */       nurishBit.set(d, 1);
/*     */     }
/* 196 */     if (newDay) {
/* 197 */       babyAge.inc(d, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 204 */     return nurishBit.get(d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\parent\AIModule_Parent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */