/*     */ package settlement.entity.humanoid.ai.types.noble;
/*     */ 
/*     */ import game.nobility.NobleOffice;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIData;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderRND;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Noble
/*     */   extends AIModule
/*     */ {
/*  27 */   private static CharSequence ¤¤name = "Be Noble";
/*  28 */   private static CharSequence ¤¤verb = "Inspecting";
/*     */   
/*     */   static {
/*  31 */     D.ts(AIModule_Noble.class);
/*     */   }
/*     */   
/*  34 */   private final AIData.AIDataBit sus = AI.bit("noble");
/*     */   
/*     */   public AIModule_Noble() {
/*  37 */     super((SPRITE)(UI.icons()).s.noble, ¤¤name, null);
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
/*     */ 
/*     */     
/*  60 */     this.beNoble = (AIPLAN)new AIPLAN.PLANRES("noble")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/*  65 */           NobleOffice o = a.noble().office();
/*  66 */           if (o != null && o.room() != null && !AIModule_Noble.this.sus.is(d)) {
/*  67 */             RoomBlueprintIns<?> b = o.room();
/*  68 */             if (b.instancesSize() > 0) {
/*  69 */               int ii = RND.rInt(b.instancesSize());
/*  70 */               for (int k = 0; k < b.instancesSize(); k++) {
/*  71 */                 RoomInstance ins = b.getInstance((ii + k) % b.instancesSize());
/*  72 */                 if (ins.employees().employed() > 0) {
/*  73 */                   AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, ins);
/*  74 */                   if (s != null) {
/*  75 */                     this.inspectRoom.set(a, d);
/*  76 */                     return s;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/*  81 */               AIModule_Noble.this.sus.set(d, true);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  89 */           return this.other.set(a, d);
/*     */         }
/*     */         
/*  92 */         private final AIPLAN.PLANRES.Resumer other = new AIPLAN.PLANRES.Resumer(this, AIModule_Noble.¤¤verb)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  96 */               AIModule_Noble.null.this.inspect.set(a, d);
/*  97 */               COORDINATE c = (SETT.PATH()).finders.randomDistanceAway.get(THRONE.coo().x(), THRONE.coo().y(), 100, SFinderRND.value);
/*  98 */               if (c != null) {
/*  99 */                 return (AI.SUBS()).walkTo.coo(a, d, c);
/*     */               }
/* 101 */               return (AI.SUBS()).STAND.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 111 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 123 */         private final AIPLAN.PLANRES.Resumer inspect = new AIPLAN.PLANRES.Resumer(this, AIModule_Noble.¤¤verb)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 127 */               d.planByte1 = 8;
/* 128 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 133 */               d.planByte1 = (byte)(d.planByte1 - 1);
/* 134 */               if (d.planByte1 <= 0)
/* 135 */                 return null; 
/* 136 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 141 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 150 */         private final AIPLAN.PLANRES.Resumer inspectRoom = new AIPLAN.PLANRES.Resumer(this, AIModule_Noble.¤¤verb)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 154 */               d.planByte1 = 16;
/* 155 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 160 */               d.planByte1 = (byte)(d.planByte1 - 1);
/* 161 */               if (d.planByte1 <= 0)
/* 162 */                 return null; 
/* 163 */               if (RND.oneIn(4)) {
/* 164 */                 RoomInstance r = (RoomInstance)(SETT.ROOMS()).map.instance.get(a.tc());
/* 165 */                 if (r != null) {
/* 166 */                   return (AI.SUBS()).walkTo.room(a, d, r);
/*     */                 }
/*     */               } 
/* 169 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 174 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 185 */           if (e.type == HPoll.WORKING) {
/* 186 */             return 1.0D;
/*     */           }
/* 188 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private final AIPLAN beNoble;
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     return this.beNoble.activate(a, d);
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {
/*     */     if (newDay)
/*     */       this.sus.set(d, false); 
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     if ((STATS.WORK()).WORK_TIME.indu().isMax(a.indu()))
/*     */       return 0; 
/*     */     return 3;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\noble\AIModule_Noble.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */