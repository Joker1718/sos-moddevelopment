/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ final class UIFactionList
/*     */   extends ISidePanel
/*     */ {
/*  46 */   private final ArrayList<FactionNPC> sorted = new ArrayList(FACTIONS.MAX());
/*     */   
/*  48 */   public static int ROW_HEIGHT = 30;
/*  49 */   private final int width = 264;
/*     */   
/*  51 */   private final StringInputSprite filter = new StringInputSprite(20, (UI.FONT()).S);
/*     */   private final GTableBuilder builder;
/*     */   private Faction hovered;
/*     */   
/*  55 */   private final Tree<FactionNPC> sorter = new Tree<FactionNPC>(FACTIONS.MAX())
/*     */     {
/*     */       protected boolean isGreaterThan(FactionNPC current, FactionNPC cmp)
/*     */       {
/*  59 */         return (value((Faction)current) > value((Faction)cmp));
/*     */       }
/*     */       
/*     */       private double value(Faction f) {
/*  63 */         double d = 1.0D - 1.0D / RD.DIST().distance(f);
/*  64 */         if (DIP.WAR().is((Faction)FACTIONS.player(), f))
/*  65 */           return 0.0D + d; 
/*  66 */         if ((DIP.get((Faction)FACTIONS.player(), f)).trades)
/*  67 */           return FACTIONS.MAX() + d; 
/*  68 */         if (RD.DIST().reachable(f))
/*  69 */           return (FACTIONS.MAX() * 2) + d; 
/*  70 */         if (RD.DIST().factionHasRegionBorderingPlayer(f))
/*  71 */           return (FACTIONS.MAX() * 3) + d; 
/*  72 */         return (FACTIONS.MAX() * 4) + d;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UIFactionList(int HEIGHT) {
/*  80 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  83 */           UIFactionList.this.sorted.clear();
/*  84 */           for (FactionNPC f : FACTIONS.NPCs())
/*  85 */             UIFactionList.this.sorter.add(f); 
/*  86 */           while (UIFactionList.this.sorter.hasMore()) {
/*  87 */             FactionNPC f = (FactionNPC)UIFactionList.this.sorter.pollSmallest();
/*  88 */             if (UIFactionList.this.filter.text().length() > 0) {
/*  89 */               if (f.name.containsText((CharSequence)UIFactionList.this.filter.text()))
/*  90 */                 UIFactionList.this.sorted.add(f);  continue;
/*     */             } 
/*  92 */             UIFactionList.this.sorted.add(f);
/*     */           } 
/*  94 */           (WORLD.OVERLAY()).factions.add();
/*     */           
/*  96 */           super.render(r, ds);
/*  97 */           UIFactionList.this.hovered = null;
/*     */         }
/*     */       };
/*     */     
/* 101 */     this.filter.placeHolder(Dic.¤¤Search);
/*     */     
/* 103 */     GInput in = new GInput(this.filter);
/*     */     
/* 105 */     this.section.addDownC(8, (RENDEROBJ)in);
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 113 */           return UIFactionList.this.sorted.size();
/*     */         }
/*     */       };
/*     */     
/* 117 */     this.builder.column(null, 264, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 121 */             return (RENDEROBJ)new UIFactionList.Button(ier);
/*     */           }
/*     */         });
/*     */     
/* 125 */     this.section.addDownC(8, (RENDEROBJ)this.builder.createHeight(HEIGHT - 16 - this.section.body().height(), false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final class Button
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private COLOR cbad;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private COLOR cSoSo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private COLOR cOK;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private COLOR cGood;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Button(GETTER<Integer> ier) {
/* 279 */       this.cbad = (COLOR)COLOR.RED100.makeSaturated(0.75D).shade(0.75D);
/* 280 */       this.cSoSo = (COLOR)COLOR.YELLOW100.makeSaturated(0.75D).shade(0.75D);
/* 281 */       this.cOK = (COLOR)COLOR.BLUE100.makeSaturated(0.75D).shade(0.75D);
/* 282 */       this.cGood = (COLOR)COLOR.NYAN100.makeSaturated(0.75D).shade(0.75D); this.ier = ier; RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(80, 64) { public void render(SPRITE_RENDERER r, float ds) { FactionNPC f = UIFactionList.Button.this.g(); if (f == null) return;  (f.banner()).HUGE.render(r, body().x1(), body().y1()); Royalty ro = f.court().king().roy(); int x1 = body().x1() + 32 + 16; int y1 = body().y1() + 8; STATS.APPEARANCE().portraitRender(r, ro.induvidual, x1, y1, 1); ((SPRITE)(ro.induvidual.race().appearance()).crown.crowns().get(0)).renderScaled(r, x1, y1 + 8, 1); } }
/*     */         ; add((RENDEROBJ)renderImp); HOVERABLE hOVERABLE = (new GStat() { public void update(GText text) { FactionNPC f = UIFactionList.Button.this.g(); if (f != null) text.lablifySub().add((CharSequence)f.name);  } }
/*     */         ).r(DIR.NW); add((RENDEROBJ)hOVERABLE, getLastX2() + 12, 4); GuiSection pp = new GuiSection(); pp.add(GMeter.sprite(GMeter.C_ORANGE, new DOUBLE() { public double getD() { FactionNPC f = UIFactionList.Button.this.g(); if (f == null) return 0.0D;  return (RD.RACES()).population.faction().get(f) / 10.0D * RD.RACES().maxPopReg(); } }, 100, 24), 0, 0); pp.addCentredY((RENDEROBJ)(new GStat() { public void update(GText text) { text.darkBG(); FactionNPC f = UIFactionList.Button.this.g(); if (f == null) return;  int am = (RD.RACES()).population.faction().get(f); GFORMAT.i(text, am); } }).hh((SPRITE)(SPRITES.icons()).s.human), 4); pp.add((SPRITE)new SPRITE.Imp(100, 16) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { FactionNPC f = UIFactionList.Button.this.g(); if (f == null) return;  double c = ROPINION.get(f.court().king().roy()); GMeter.GMeterCol col = (c < (DIP.get(f)).opinionNeeded) ? GMeter.C_RED : GMeter.C_BLUE; c /= (DIP.ALLY()).opinionNeeded + 1.0D; GMeter.render(r, col, c, X1, X2, Y1, Y2); int x1 = (int)(X1 + (X2 - X1) * (DIP.get(f)).opinionNeeded / ((DIP.ALLY()).opinionNeeded + 1.0D)); GCOLOR.UI().border().render(r, x1 - 2, x1 + 2, Y1, Y2); } }0, pp.body().y2() + 4); pp.addRelBody(8, DIR.E, (SPRITE)new SPRITE.Imp(32) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { FactionNPC f = UIFactionList.Button.this.g(); if (DIP.get(f) != DIP.NEUTRAL()) (DIP.get(f)).icon.render(r, X1, X2, Y1, Y2);  } }); add((RENDEROBJ)pp, getLastX1(), getLastY2() + 4); pad(8, 6); body().setWidth(264.0D);
/* 285 */     } private void bg(SPRITE_RENDERER r) { ColorImp colorImp; FactionNPC f = g();
/*     */       
/* 287 */       double v = ROPINION.trust().get(f);
/*     */       
/* 289 */       COLOR c = this.cbad;
/* 290 */       if (v < 1.0D) {
/* 291 */         colorImp = ColorImp.TMP.interpolate(this.cbad, this.cSoSo, v);
/*     */       } else {
/* 293 */         colorImp = ColorImp.TMP.interpolate(this.cOK, this.cGood, v - 1.0D);
/*     */       } 
/* 295 */       if (selectedIs()) {
/* 296 */         OPACITY.O75.bind();
/* 297 */       } else if (hoveredIs()) {
/* 298 */         OPACITY.O66.bind();
/*     */       } else {
/* 300 */         OPACITY.O50.bind();
/* 301 */       }  colorImp.render(r, (RECTANGLE)body(), -4);
/* 302 */       OPACITY.unbind(); }
/*     */     public void render(SPRITE_RENDERER r, float ds) { boolean hovered = hoveredIs(); FactionNPC f = g(); boolean selected = (VIEW.world()).UI.factions.openIs((Faction)f); boolean active = (f.capitolRegion() != null); int i = hovered | ((UIFactionList.this.hovered == f) ? 1 : 0); if (i != 0 || selected) {
/*     */         WORLD.MINIMAP().hilight((Faction)f); WORLD.OVERLAY().hover(f.capitolRegion());
/*     */       }  GButt.ButtPanel.renderBG(r, active, selected, i, (RECTANGLE)body()); bg(r); super.render(r, ds); if (!RD.DIST().reachable((Faction)f)) {
/*     */         OPACITY.O50.bind(); COLOR.BLACK.render(r, (RECTANGLE)body(), -4); OPACITY.unbind();
/*     */       } 
/* 308 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body()); } public boolean click() { UIFactionList.this.open(g(), false);
/* 309 */       return super.click(); }
/*     */ 
/*     */     
/*     */     private FactionNPC g() {
/* 313 */       return (FactionNPC)UIFactionList.this.sorted.get(((Integer)this.ier.get()).intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 318 */       super.hoverInfoGet(text);
/* 319 */       if (text.emptyIs()) {
/* 320 */         (VIEW.world()).UI.factions.hover(text, (Faction)g());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void open(FactionNPC f, boolean shove) {
/* 328 */     if (f != null) {
/* 329 */       if (shove)
/* 330 */         this.builder.set(this.sorted.indexOf(f)); 
/* 331 */       (VIEW.world()).UI.factions.open(f);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void hover(Faction f) {
/* 340 */     this.hovered = f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIFactionList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */