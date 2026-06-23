/*     */ package settlement.job;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import util.colors.COLOR_MAP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ON_TOP_RENDERABLE
/*     */ {
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 159 */     RenderData.RenderIterator i = data.onScreenTiles();
/* 160 */     COLOR_MAP c = GCOLOR.MAP();
/* 161 */     while (i.has()) {
/*     */       
/* 163 */       int index = JOBS.this.map.get(i.tile());
/*     */       
/* 165 */       if (index != 0) {
/*     */         
/* 167 */         index--;
/*     */         
/* 169 */         if (i.tile() == JOBS.this.hoverI) {
/* 170 */           COLOR.WHITE2WHITE.bind();
/*     */         } else {
/*     */           
/* 173 */           switch (JOBS.this.state.get(i.tile())) {
/*     */             case DORMANT:
/* 175 */               c.DORMANT.bind();
/*     */               break;
/*     */             case RESERVABLE:
/* 178 */               c.JOB_ACTIVE.bind();
/*     */               break;
/*     */             case RESERVED:
/* 181 */               c.JOB_RESERVED.bind();
/*     */               break;
/*     */             case null:
/* 184 */               c.JOB_BLOCKED.bind();
/*     */               break;
/*     */           } 
/*     */         
/*     */         } 
/* 189 */         Job j = (Job)Job.all.get(index);
/*     */         
/* 191 */         if (j != null)
/*     */         {
/* 193 */           j.renderAbove((SPRITE_RENDERER)r, i.x(), i.y(), 0, i.tx(), i.ty());
/*     */           
/* 195 */           if (CORE.renderer().getZoomout() <= 1) {
/* 196 */             j.get(i.tx(), i.ty());
/* 197 */             RESOURCE res = j.resourceCurrentlyNeeded();
/* 198 */             if ((j == JOBS.this.clearss.food && !(SETT.WEATHER()).growthRipe.cropsAreRipe()) || (res != null && 
/* 199 */               !j.jobReservedIs(res) && !(SETT.PATH()).finders.resource.normal.has(i.tx(), i.ty(), res))) {
/* 200 */               COLOR.WHITE702WHITE100.bind();
/* 201 */               (SPRITES.cons()).ICO.warning.render((SPRITE_RENDERER)r, i.x(), i.y());
/* 202 */               COLOR.unbind();
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 210 */       else if (SETT.TERRAIN().get(i.tile()) instanceof TGrowable && 
/* 211 */         ((TGrowable)(SETT.TERRAIN()).GROWABLES.get(0)).job.is(i.tile())) {
/* 212 */         if (i.tile() == JOBS.this.hoverI) {
/* 213 */           COLOR.WHITE2WHITE.bind();
/*     */         } else {
/* 215 */           c.DORMANT.bind();
/*     */         } 
/*     */         
/* 218 */         (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)r, 0, i.x(), i.y());
/*     */       } 
/*     */       
/* 221 */       i.next();
/*     */     } 
/* 223 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JOBS$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */