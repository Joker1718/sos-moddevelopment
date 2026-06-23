/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 111 */     d.planTile.set(d.path.destX(), d.path.destY());
/* 112 */     d.planByte1 = (byte)(5 + RND.rInt(10));
/*     */     
/* 114 */     FSERVICE s = (FSERVICE)S_PlanShrine.null.this.temp(d).service(d.planTile.x(), d.planTile.y()).get(d.planTile.x(), d.planTile.y());
/* 115 */     if (s != null) {
/* 116 */       s.startUsing();
/*     */     }
/* 118 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(a.tc());
/* 119 */     if (it != null) {
/* 120 */       COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(a.tc(), Coo.TMP);
/* 121 */       if (c != null) {
/*     */         
/* 123 */         int dx = c.x() + it.width() / 2;
/* 124 */         int dy = c.y() + it.height() / 2;
/*     */         
/* 126 */         DIR dir = DIR.get(a.tc().x(), a.tc().y(), dx, dy);
/* 127 */         a.speed.setDirCurrent(dir);
/*     */       } 
/*     */     } 
/*     */     
/* 131 */     return res(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 136 */     d.planByte1 = (byte)(d.planByte1 - 1);
/* 137 */     if (d.planByte1 <= 0) {
/* 138 */       can(a, d);
/* 139 */       return null;
/*     */     } 
/* 141 */     if (RND.rBoolean()) {
/* 142 */       return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.lay, (4 + RND.rInt(4)));
/*     */     }
/* 144 */     if (RND.rBoolean())
/* 145 */       return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.carry, (4 + RND.rInt(4))); 
/* 146 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stand, (4 + RND.rInt(4)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 157 */     FINDABLE s = (S_PlanShrine.null.this.temp(d).service()).finder.getReserved(d.planTile.x(), d.planTile.y());
/* 158 */     if (s != null) {
/* 159 */       s.findableReserveCancel();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 164 */     string.add((S_PlanShrine.null.this.temp(d).service()).verb);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_PlanShrine$1$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */