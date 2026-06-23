/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDReligions;
/*     */ 
/*     */ final class PlayReligion
/*     */   extends GuiSection
/*     */ {
/*     */   private GETTER.GETTER_IMP<Region> g;
/*     */   
/*     */   PlayReligion(final GETTER.GETTER_IMP<Region> g, int W) {
/*  31 */     this.g = g;
/*  32 */     int i = 0;
/*     */     
/*  34 */     int w = 90;
/*  35 */     int cols = W / w;
/*     */     
/*  37 */     for (RDReligions.RDReligion reg : RD.RELIGION().all()) {
/*  38 */       addGridD(rel(reg), i++, cols, w, 34, DIR.W);
/*     */     }
/*  40 */     i++;
/*  41 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  45 */             GFORMAT.percInv(text, (RD.RELIGION()).opposition.getD(g.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  50 */             (STATS.RELIGION()).OPPOSITION.info().hover((GUI_BOX)b);
/*     */           }
/*  52 */         }).hh((SPRITE)(UI.icons()).m.cancel), i++, cols, w, 34, DIR.W);
/*     */     
/*  54 */     pad((W - body().width()) / 2, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ rel(final RDReligions.RDReligion rel) {
/*  63 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  67 */           rel.religion.info.hover(text);
/*  68 */           GBox b = (GBox)text;
/*  69 */           b.sep();
/*  70 */           rel.boost.hover((GUI_BOX)b, (BOOSTABLE_O)PlayReligion.this.g.get(), Dic.¤¤Spread, false);
/*  71 */           b.sep();
/*     */ 
/*     */           
/*  74 */           rel.boosts.hover(text, (BOOSTABLE_O)PlayReligion.this.g.get());
/*     */           
/*  76 */           b.sep();
/*  77 */           b.textSLL(((STATS.RELIGION()).OPPOSITION.info()).name);
/*  78 */           b.NL();
/*  79 */           int tab = 0;
/*  80 */           for (Religion o : RELIGIONS.ALL()) {
/*  81 */             b.tab(tab);
/*  82 */             b.text(o.info.name);
/*  83 */             b.tab(tab + 6);
/*  84 */             b.add((SPRITE)GFORMAT.percInv(b.text(), rel.religion.opposition(o)));
/*  85 */             tab += 8;
/*  86 */             if (tab > 8) {
/*  87 */               b.NL();
/*  88 */               tab = 0;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*  93 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     s.add((SPRITE)new SPRITE.Imp(48, 14)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 104 */             double now = rel.current.getD(PlayReligion.this.g.get());
/* 105 */             double t = rel.target((Region)PlayReligion.this.g.get());
/* 106 */             GMeter.render(r, GMeter.C_REDPURPLE, now, t, X1, X2, Y1, Y2);
/*     */           }
/* 108 */         }0, 0);
/*     */     
/* 110 */     s.addCentredY((SPRITE)rel.religion.icon, -30);
/*     */     
/* 112 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayReligion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */