/*     */ package settlement.entity.humanoid.ai.types.noble;
/*     */ 
/*     */ import game.nobility.NobleOffice;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderRND;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer other;
/*     */   private final AIPLAN.PLANRES.Resumer inspect;
/*     */   private final AIPLAN.PLANRES.Resumer inspectRoom;
/*     */   
/*     */   null(String $anonymous0) {
/*  60 */     super($anonymous0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     this.other = new AIPLAN.PLANRES.Resumer(this, AIModule_Noble.¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  96 */           AIModule_Noble.null.this.inspect.set(a, d);
/*  97 */           COORDINATE c = (SETT.PATH()).finders.randomDistanceAway.get(THRONE.coo().x(), THRONE.coo().y(), 100, SFinderRND.value);
/*  98 */           if (c != null) {
/*  99 */             return (AI.SUBS()).walkTo.coo(a, d, c);
/*     */           }
/* 101 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 111 */           return true;
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
/* 123 */     this.inspect = new AIPLAN.PLANRES.Resumer(this, AIModule_Noble.¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 127 */           d.planByte1 = 8;
/* 128 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 133 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 134 */           if (d.planByte1 <= 0)
/* 135 */             return null; 
/* 136 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 141 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 150 */     this.inspectRoom = new AIPLAN.PLANRES.Resumer(this, AIModule_Noble.¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 154 */           d.planByte1 = 16;
/* 155 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 160 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 161 */           if (d.planByte1 <= 0)
/* 162 */             return null; 
/* 163 */           if (RND.oneIn(4)) {
/* 164 */             RoomInstance r = (RoomInstance)(SETT.ROOMS()).map.instance.get(a.tc());
/* 165 */             if (r != null) {
/* 166 */               return (AI.SUBS()).walkTo.room(a, d, r);
/*     */             }
/*     */           } 
/* 169 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 174 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 185 */     if (e.type == HPoll.WORKING) {
/* 186 */       return 1.0D;
/*     */     }
/* 188 */     return super.poll(a, d, e);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     NobleOffice o = a.noble().office();
/*     */     if (o != null && o.room() != null && !AIModule_Noble.this.sus.is(d)) {
/*     */       RoomBlueprintIns<?> b = o.room();
/*     */       if (b.instancesSize() > 0) {
/*     */         int ii = RND.rInt(b.instancesSize());
/*     */         for (int k = 0; k < b.instancesSize(); k++) {
/*     */           RoomInstance ins = b.getInstance((ii + k) % b.instancesSize());
/*     */           if (ins.employees().employed() > 0) {
/*     */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, ins);
/*     */             if (s != null) {
/*     */               this.inspectRoom.set(a, d);
/*     */               return s;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         AIModule_Noble.this.sus.set(d, true);
/*     */       } 
/*     */     } 
/*     */     return this.other.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\noble\AIModule_Noble$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */