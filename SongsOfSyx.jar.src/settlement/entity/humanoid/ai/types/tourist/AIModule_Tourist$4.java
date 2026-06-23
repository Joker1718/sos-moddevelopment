/*     */ package settlement.entity.humanoid.ai.types.tourist;
/*     */ 
/*     */ import game.tourism.TOURISM;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */   private final AIPLAN.PLANRES.Resumer inspect;
/*     */   
/*     */   null(String $anonymous0) {
/* 277 */     super($anonymous0);
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
/* 309 */     this.inspect = new AIPLAN.PLANRES.Resumer(this, "Inspecting")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 313 */           d.planByte1 = 24;
/* 314 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 319 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 320 */           if (d.planByte1 <= 0) {
/* 321 */             (AIModules.data()).byte1.orSet(d, 8);
/* 322 */             return null;
/*     */           } 
/* 324 */           RoomInstance r = (RoomInstance)(SETT.ROOMS()).map.instance.get(a.tc());
/* 325 */           if (r != null && RND.oneIn(5)) {
/* 326 */             return (AI.SUBS()).walkTo.room(a, d, r);
/*     */           }
/* 328 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 333 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 338 */           if (e.event == HEvent.INTERRACT) {
/* 339 */             (AIModules.data()).byte1.orSet(d, 8);
/*     */           }
/* 341 */           return super.event(a, d, e);
/*     */         }
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e)
/*     */         {
/* 346 */           if (e.type == HPoll.CAN_INTERRACT)
/* 347 */             return 1.0D; 
/* 348 */           return super.poll(a, d, e);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 360 */     string.add(AIModule_Tourist.¤¤sight);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     d.planByte2 = 4;
/*     */     RoomBlueprintIns<?> b = TOURISM.attraction(a.indu());
/*     */     if (b.instancesSize() > 0) {
/*     */       int ii = RND.rInt(b.instancesSize());
/*     */       for (int k = 0; k < b.instancesSize(); k++) {
/*     */         RoomInstance ins = b.getInstance((ii + k) % b.instancesSize());
/*     */         if (ins.reachable())
/*     */           if (ins.employees().employed() > 0 && ins.reachable()) {
/*     */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, ins);
/*     */             if (s != null) {
/*     */               this.inspect.set(a, d);
/*     */               return s;
/*     */             } 
/*     */           }  
/*     */       } 
/*     */     } 
/*     */     this.inspect.set(a, d);
/*     */     if ((SETT.PATH()).finders.randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64))
/*     */       return (AI.SUBS()).walkTo.path(a, d); 
/*     */     return (AI.SUBS()).STAND.activate(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\tourist\AIModule_Tourist$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */