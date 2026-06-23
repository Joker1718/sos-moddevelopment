/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.main.VIEW;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ class Other extends ISidePanel implements RV {
/*  41 */   private static CharSequence ¤¤eCurrent = "Assigned envoys";
/*  42 */   private static CharSequence ¤¤eAvailable = "Available envoys"; public static final int width = 450;
/*     */   static {
/*  44 */     D.ts(Other.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  49 */   private GETTER.GETTER_IMP<Region> g = new GETTER.GETTER_IMP();
/*  50 */   private final RENDEROBJ mi = MiscMore.garrison(this.g, 288);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Faction ff;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final OtherHov hov;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISidePanel get(Region reg) {
/*  76 */     this.g.set(reg);
/*  77 */     this.ff = reg.faction();
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ banner(final GETTER.GETTER_IMP<Region> g, ISidePanel panel, final ISidePanels p) {
/*  85 */     GuiSection s = new GuiSection();
/*  86 */     s.add((RENDEROBJ)new CLICKABLE.ClickableAbs(80, 80)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/*  90 */             (VIEW.world()).UI.factions.hover(text, ((Region)g.get()).faction());
/*  91 */             super.hoverInfoGet(text);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  97 */             Region reg = (Region)g.get();
/*  98 */             if (reg.faction() == null) {
/*  99 */               FBanner.rebel.HUGE.renderC(r, body().cX(), body().cY());
/*     */             } else {
/* 101 */               GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)body());
/* 102 */               (reg.faction().banner()).HUGE.renderC(r, body().cX(), body().cY());
/* 103 */               if (DIP.WAR().is((Faction)FACTIONS.player(), reg.faction())) {
/* 104 */                 COLOR.REDISH.bind();
/* 105 */                 (UI.icons()).s.sword.render(r, body().x2() - 16, body().y1());
/*     */               } 
/* 107 */               GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 114 */             if (((Region)g.get()).faction() instanceof FactionNPC) {
/* 115 */               (VIEW.world()).UI.factions.open((FactionNPC)((Region)g.get()).faction());
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 120 */     s.add((RENDEROBJ)(new GStat((UI.FONT()).H2)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 124 */             text.lablify();
/* 125 */             text.add((CharSequence)((Region)g.get()).info.name());
/*     */           }
/* 128 */         }).r(DIR.NW), s.getLastX2() + 16, s.getLastY1() + 8);
/*     */ 
/*     */     
/* 131 */     if ((S.get()).developer) {
/* 132 */       s.add((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */           {
/*     */             protected void clickA() {
/* 135 */               p.add((VIEW.world()).UI.regions.player.get((Region)g.get()), true);
/*     */             }
/* 137 */           }s.getLastX1(), s.getLastY2() + 4);
/*     */     }
/*     */     
/* 140 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   private static class Emiss
/*     */     extends GuiSection {
/*     */     private final GETTER.GETTER_IMP<Region> g;
/*     */     
/*     */     Emiss(final GETTER.GETTER_IMP<Region> g) {
/* 148 */       this.g = g;
/*     */       
/* 150 */       add((SPRITE)(UI.icons()).m.flag, 0, 0);
/*     */       
/* 152 */       int wi = 150;
/*     */       
/* 154 */       RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(wi, 18)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 158 */             GMeter.render(r, GMeter.C_REDGREEN, (RD.OWNER()).affiliation.getD(g.get()), (RECTANGLE)body());
/*     */           }
/*     */         };
/*     */       
/* 162 */       addRightC(16, (RENDEROBJ)renderImp);
/*     */       
/* 164 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 168 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 173 */             return (FACTIONS.player()).emissaries.assimilate.max(g.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 178 */             return (FACTIONS.player()).emissaries.assimilate.get(g.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 183 */             (FACTIONS.player()).emissaries.assimilate.set(g.get(), t);
/*     */           }
/*     */         };
/*     */       
/* 187 */       GSliderInt sl = new GSliderInt(ii, wi / 2, true);
/*     */       
/* 189 */       addRightC(16, (RENDEROBJ)sl);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 197 */       GBox b = (GBox)text;
/* 198 */       b.title(((RD.OWNER()).affiliation.info()).name);
/* 199 */       b.text(((RD.OWNER()).affiliation.info()).desc);
/* 200 */       b.NL(8);
/* 201 */       b.textLL(Other.¤¤eCurrent);
/* 202 */       b.tab(7);
/* 203 */       b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).emissaries.assimilate.get(this.g.get())));
/* 204 */       b.NL();
/* 205 */       b.textLL(Other.¤¤eAvailable);
/* 206 */       b.tab(7);
/* 207 */       b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).emissaries.available()));
/* 208 */       b.NL();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ info(GETTER.GETTER_IMP<Region> g) {
/* 214 */     return (RENDEROBJ)MiscBasics.info((GETTER<Region>)g);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ infoMore(GETTER.GETTER_IMP<Region> g) {
/* 220 */     GuiSection s = new GuiSection();
/* 221 */     s.add(MiscBasics.rel((GETTER<Region>)g));
/* 222 */     s.addDownC(2, MiscBasics.prospect((GETTER<Region>)g));
/* 223 */     return (RENDEROBJ)new Mystery(g, (RENDEROBJ)s, 0.1D);
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ more(final GETTER.GETTER_IMP<Region> g) {
/* 228 */     GuiSection ss = new GuiSection();
/* 229 */     ss.body().incrW(64.0D);
/* 230 */     ss.body().incrH(1.0D);
/*     */ 
/*     */     
/* 233 */     ss.addRightC(0, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 237 */             GFORMAT.iofkInv(text, (RD.MILITARY()).garrison.get((Region)g.get()), RD.MILITARY().garrisonTarget((Region)g.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 242 */             b.title(Dic.¤¤garrison);
/*     */           }
/* 245 */         }).hv((SPRITE)(UI.icons()).m.shield));
/* 246 */     ss.addRightC(64, MiscMore.garrison(g, 450 - ss.body().width() - 64));
/*     */     
/* 248 */     return (RENDEROBJ)new Mystery(g, (RENDEROBJ)ss, 0.5D);
/*     */   }
/*     */   
/*     */   private static RENDEROBJ buildings(GETTER.GETTER_IMP<Region> g) {
/* 252 */     RENDEROBJ ii = MiscMore.buildings(g);
/* 253 */     return (RENDEROBJ)new Mystery(g, ii, 0.25D);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Mystery
/*     */     extends CLICKABLE.ClickWrap
/*     */   {
/*     */     final RENDEROBJ obj;
/*     */ 
/*     */     
/*     */     Mystery(GETTER.GETTER_IMP<Region> g, RENDEROBJ obj, double reveal) {
/* 264 */       super(obj);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 293 */       this.obj = obj;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected RENDEROBJ pget() {
/* 302 */       return this.obj;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Other(ToolManager m, ISidePanels p) {
/* 308 */     this.hov = new OtherHov(); titleSet(Dic.¤¤Region); this.section = new GuiSection() { public void render(SPRITE_RENDERER r, float ds) { if (Other.this.ff != ((Region)Other.this.g.get()).faction())
/*     */             Other.this.last().remove(Other.this);  super.render(r, ds); } }
/*     */       ; this.section.addDown(0, banner(this.g, this, p)); this.section.addDown(8, (RENDEROBJ)new Emiss(this.g)); this.section.addRelBody(8, DIR.S, info(this.g)); this.section.addRelBody(8, DIR.S, infoMore(this.g));
/*     */     this.section.addRelBody(8, DIR.S, buildings(this.g));
/* 312 */     this.section.addRelBody(8, DIR.S, more(this.g)); } public void hover(GBox box, Region reg) { this.hov.hover(reg, (GUI_BOX)box); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean added(ISidePanels pans, Region reg) {
/* 320 */     return (pans.added(this) && reg == this.g.get());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(float ds) {
/* 325 */     WORLD.OVERLAY().hover((Region)this.g.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverGarrison(GBox box, Region reg) {
/* 330 */     box.title((CharSequence)reg.info.name());
/* 331 */     this.g.set(reg);
/* 332 */     box.add(this.mi);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\Other.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */