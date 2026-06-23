/*     */ package world.region;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.BitmapSpriteEditor;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   GETTER.GETTER_IMP<FactionNPC> g;
/*     */   GuiSection s;
/*     */   BitmapSpriteEditor ee;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 193 */     super($anonymous0);
/* 194 */     this.g = new GETTER.GETTER_IMP();
/* 195 */     this.s = new GuiSection();
/* 196 */     this.ee = new BitmapSpriteEditor();
/*     */     
/* 198 */     this.s.add((RENDEROBJ)this.ee);
/* 199 */     this.s.addRelBody(8, DIR.S, (RENDEROBJ)new GColorPicker(true)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/* 203 */             return ((FactionNPC)Placers.null.this.g.get()).banner().colorBG();
/*     */           }
/*     */         });
/* 206 */     this.s.addRelBody(8, DIR.S, (RENDEROBJ)new GColorPicker(true)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/* 210 */             return ((FactionNPC)Placers.null.this.g.get()).banner().colorFG();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 219 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 220 */     if (reg != null && reg.faction() instanceof FactionNPC) {
/* 221 */       this.g.set(reg.faction());
/* 222 */       this.ee.spriteSet((reg.faction().banner()).sprite);
/* 223 */       (VIEW.inters()).popup.show((RENDEROBJ)this.s, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 229 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 230 */     if (reg != null && reg.faction() instanceof FactionNPC) {
/* 231 */       return null;
/*     */     }
/* 233 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 238 */     return (SPRITE)(UI.icons()).m.flag;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Placers$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */