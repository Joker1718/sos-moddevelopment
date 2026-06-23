/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.constant.Config;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import view.main.VIEW;
/*     */ import view.world.ui.WorldHoverer;
/*     */ import world.army.AD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Button
/*     */   extends GButt.BSection
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   Button(GETTER<Integer> ier) {
/* 271 */     this.ier = ier;
/* 272 */     add((SPRITE)new GStat((UI.FONT()).M)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 276 */             text.lablify();
/* 277 */             text.add((CharSequence)(List.Button.this.g()).name, 12);
/*     */           }
/* 279 */         }0, 0);
/*     */     
/* 281 */     addRightCAbs(List.width, (RENDEROBJ)new RENDEROBJ.RenderImp(16)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 286 */             if (List.Button.this.g().region() != null && DIP.WAR().is(List.Button.this.g().region().faction(), (Faction)GAME.player())) {
/* 287 */               (GCOLOR.T()).IBAD.bind();
/* 288 */               (SPRITES.icons()).s.world.render(r, (RECTANGLE)this.body);
/* 289 */               COLOR.unbind();
/*     */             }
/* 291 */             else if (List.Button.this.g().path().moving(List.Button.this.g().body())) {
/* 292 */               (SPRITES.icons()).s.crossheir.render(r, (RECTANGLE)this.body);
/* 293 */             } else if (List.Button.this.g().recruiting()) {
/* 294 */               (SPRITES.icons()).s.muster.render(r, (RECTANGLE)this.body);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 302 */     add((RENDEROBJ)new RENDEROBJ.RenderImp(body().width(), 12)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 306 */             double dw = AD.menTarget(null).get(List.Button.this.g()) / (Config.battle()).MEN_PER_ARMY;
/* 307 */             dw = Math.sqrt(dw);
/* 308 */             int ww = (int)(this.body.width() * dw);
/* 309 */             GMeter.renderDelta(r, AD.men(null).get(List.Button.this.g()) / AD.menTarget(null).get(List.Button.this.g()), 1.0D, this.body.x1(), this.body.x1() + ww, this.body.y1(), this.body.y2());
/*     */           }
/* 312 */         }0, body().y2() + 4);
/*     */ 
/*     */ 
/*     */     
/* 316 */     pad(6, 6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 321 */     WorldHoverer.hover(text, (WEntity)g());
/*     */   }
/*     */   
/*     */   private WArmy g() {
/* 325 */     return (WArmy)List.this.f.armies().all().get(((Integer)this.ier.get()).intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 330 */     (VIEW.world()).UI.armies.openList(g(), List.this.last());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 335 */     selectedSet((List.this.last().added((VIEW.world()).UI.armies.army) && Army.army == g()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\List$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */