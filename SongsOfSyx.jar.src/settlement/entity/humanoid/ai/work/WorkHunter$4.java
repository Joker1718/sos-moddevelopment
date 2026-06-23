/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES) {
/* 160 */     super(paramPLANRES);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 165 */     AnimalSpecies ss = spe();
/* 166 */     ThingsCadavers.Cadaver c = (SETT.THINGS()).cadavers.normal(a.tc().x(), a.tc().y(), ss.mass() * RND.rFloat1(1.1D), 1.0F, ss, 2);
/* 167 */     if (c == null) {
/* 168 */       return null;
/*     */     }
/* 170 */     d.planObject = c.index();
/* 171 */     RoomInstance in = WorkHunter.work(a);
/*     */     
/* 173 */     COORDINATE j = WorkHunter.this.b.reserveWork(in, a);
/*     */     
/* 175 */     if (j == null) {
/* 176 */       GAME.Notify("Weird " + in.mX() + " " + in.mY());
/* 177 */       return null;
/*     */     } 
/* 179 */     d.planTile.set(j);
/*     */     
/* 181 */     AISUB.AISubActivation ac = (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).cadavers.draggable, c.index(), (COORDINATE)d.planTile);
/* 182 */     if (ac != null) {
/* 183 */       return ac;
/*     */     }
/* 185 */     can(a, d);
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private ThingsCadavers.Cadaver getCadaver(Humanoid a, AIManager d) {
/* 191 */     if (d.planObject == -1)
/* 192 */       return null; 
/* 193 */     ThingsCadavers.Cadaver e = (SETT.THINGS()).cadavers.getByIndex(d.planObject);
/*     */     
/* 195 */     if (e == null || e.isRemoved() || !e.resHas()) {
/* 196 */       d.planObject = -1;
/* 197 */       return null;
/*     */     } 
/* 199 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 204 */     ThingsCadavers.Cadaver old = (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get((COORDINATE)d.planTile);
/* 205 */     if (old != null)
/* 206 */       old.remove(); 
/* 207 */     ThingsCadavers.Cadaver c = getCadaver(a, d);
/* 208 */     c.drag((DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)d.planTile)).rotation), (d.planTile.x() << 6) + 32, (d.planTile.y() << 6) + 32, 0);
/* 209 */     return WorkHunter.this.butcher.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 214 */     WorkHunter.this.b.workFinish((COORDINATE)d.planTile);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 219 */     return (WorkHunter.work(a) != null && WorkHunter.work(a).blueprint() == WorkHunter.this.b && getCadaver(a, d) != null);
/*     */   }
/*     */   
/*     */   private AnimalSpecies spe() {
/* 223 */     double tot = 0.0D;
/* 224 */     for (AnimalSpecies s : SETT.ANIMALS().sett()) {
/* 225 */       tot += s.occurence(SETT.WORLD_AREA().climate());
/*     */     }
/* 227 */     tot *= RND.rFloat();
/* 228 */     for (AnimalSpecies s : SETT.ANIMALS().sett()) {
/* 229 */       tot -= s.occurence(SETT.WORLD_AREA().climate());
/* 230 */       if (tot <= 0.0D)
/* 231 */         return s; 
/*     */     } 
/* 233 */     return (AnimalSpecies)SETT.ANIMALS().sett().rnd();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkHunter$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */