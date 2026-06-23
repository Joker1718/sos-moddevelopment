/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.updating.IUpdater;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends IUpdater
/*     */ {
/*     */   null(int $anonymous0, double $anonymous1) {
/* 183 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(int i, double timeSinceLast) {
/* 188 */     if (VIEW.b().isActive()) {
/*     */       return;
/*     */     }
/* 191 */     ENTITY e = SETT.ENTITIES().getByIndex(i);
/* 192 */     if (e != null && e instanceof Humanoid) {
/* 193 */       Humanoid a = (Humanoid)e;
/* 194 */       if (StatsReproduction.this.fertile.indu().get(a.indu()) != 1)
/*     */         return; 
/* 196 */       if (StatsReproduction.this.newInfantsAllowed(a.indu().clas(), a.race()) <= 0)
/*     */         return; 
/* 198 */       double rate = (BOOSTABLES.PHYSICS()).REPRODUCTION_SPEED.get((BOOSTABLE_O)a.indu()) / 4.0D;
/* 199 */       if (a.indu().hType() == HTYPES.SLAVE()) {
/* 200 */         rate *= (StatsReproduction.this.fertile.data(HCLASSES.SLAVE()).get(a.race()) + 1.0D) / (StatsReproduction.this.fertile.type().get(HTYPE_RACE.get(a.indu())) + 1.0D);
/* 201 */         inpregnate(a, rate, HTYPES.PARENT_SLAVE());
/* 202 */       } else if (a.indu().hType() == HTYPES.SUBJECT()) {
/* 203 */         rate *= (StatsReproduction.this.fertile.data(HCLASSES.CITIZEN()).get(a.race()) + 1.0D) / (StatsReproduction.this.fertile.type().get(HTYPE_RACE.get(a.indu())) + 1.0D);
/* 204 */         inpregnate(a, rate, HTYPES.PARENT());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void inpregnate(Humanoid a, double chance, HTYPE parent) {
/* 215 */     if (chance < RND.rFloat()) {
/*     */       return;
/*     */     }
/* 218 */     a.HTypeSet(parent, null, null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReproduction$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */