/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.battle.spec.WBattleSide;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ import world.map.landmark.WorldLandmark;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Battle
/*     */ {
/*  41 */   private static CharSequence ¤¤battleOf = "Battle of {0}";
/*  42 */   private static CharSequence ¤¤battle = "Battle";
/*  43 */   public static CharSequence ¤¤Annihilation = "¤Annihilation";
/*  44 */   public static CharSequence ¤¤Command = "¤Command";
/*  45 */   public static CharSequence ¤¤autoD = "¤Auto resolve this battle. The result will be {0}. You will lose about {1} men and inflict about {2} casualties on the enemy.";
/*  46 */   public static CharSequence ¤¤AutoResolve = "¤Auto";
/*  47 */   public static CharSequence ¤¤defence = "¤This unit is defending and is given extra power due to their defensive position.";
/*     */   
/*     */   static {
/*  50 */     D.ts(Battle.class);
/*     */   }
/*     */   
/*  53 */   private final int WIDTH = 300;
/*     */   
/*     */   private boolean hovRetreat = false;
/*     */   private boolean hovAuto = false;
/*     */   protected WBattleSpec g;
/*     */   
/*  59 */   private final GuiSection sec = new GuiSection()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds) {
/*  62 */         super.render(r, ds);
/*  63 */         Battle.this.hovRetreat = false;
/*  64 */         Battle.this.hovAuto = false;
/*  65 */         CharSequence title = Battle.this.title(Battle.this.g);
/*  66 */         int w = (UI.FONT()).H2.width(title);
/*  67 */         (UI.PANEL()).titleBoxes[1].renderCY(r, body().cX() - w / 2, body().y1() - 16, w);
/*  68 */         (GCOLOR.T()).H1.bind();
/*  69 */         (UI.FONT()).H2.renderC(r, body().cX(), body().y1() - 16, title);
/*  70 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   Battle(CharSequence desc) {
/*  76 */     GETTER<WBattleSide> pg = new GETTER<WBattleSide>()
/*     */       {
/*     */         public WBattleSide get()
/*     */         {
/*  80 */           return Battle.this.g.player;
/*     */         }
/*     */       };
/*     */     
/*  84 */     this.sec.add((RENDEROBJ)side(pg, GMeter.C_REDGREEN));
/*  85 */     GETTER<WBattleSide> sg = new GETTER<WBattleSide>()
/*     */       {
/*     */         public WBattleSide get()
/*     */         {
/*  89 */           return Battle.this.g.enemy;
/*     */         }
/*     */       };
/*     */     
/*  93 */     this.sec.addRightC(8, (RENDEROBJ)side(sg, GMeter.C_REDORANGE));
/*     */     
/*  95 */     this.sec.addRelBody(16, DIR.N, (RENDEROBJ)balance(pg, sg));
/*  96 */     this.sec.addRelBody(8, DIR.N, (RENDEROBJ)new RENDEROBJ.RenderDummy(10, 8));
/*     */     
/*  98 */     CharSequence[] descs = (UI.FONT()).M.getRows(desc, 600); byte b; int i;
/*     */     CharSequence[] arrayOfCharSequence1;
/* 100 */     for (i = (arrayOfCharSequence1 = descs).length, b = 0; b < i; ) { CharSequence d = arrayOfCharSequence1[b];
/* 101 */       GText t = new GText((UI.FONT()).M, d);
/* 102 */       t.warnify();
/* 103 */       this.sec.addRelBody(4, DIR.S, (SPRITE)t); b++; }
/*     */     
/* 105 */     this.sec.addRelBody(8, DIR.S, buttons());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence title(WBattleSpec g) {
/* 112 */     WorldLandmark m = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(g.player.coo());
/* 113 */     if (m == null) {
/* 114 */       Region reg = (Region)(WORLD.REGIONS()).map.get(g.player.coo());
/* 115 */       if (reg != null)
/* 116 */         return (CharSequence)Str.TMP.clear().add(¤¤battleOf).insert(0, (CharSequence)reg.info.name()); 
/* 117 */       return ¤¤battle;
/*     */     } 
/* 119 */     return (CharSequence)Str.TMP.clear().add(¤¤battleOf).insert(0, (CharSequence)m.name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract RENDEROBJ buttons();
/*     */ 
/*     */   
/*     */   public static GuiSection balance(final GETTER<WBattleSide> player, final GETTER<WBattleSide> enemy) {
/* 128 */     GuiSection s = new GuiSection();
/*     */     
/* 130 */     HOVERABLE.HoverableAbs hoverableAbs = new HOVERABLE.HoverableAbs(200, 24)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 135 */           double d = ((WBattleSide)player.get()).powerBalance();
/* 136 */           if (d < 0.5D) {
/* 137 */             GMeter.render(r, GMeter.C_RED, d, (RECTANGLE)this.body);
/*     */           } else {
/* 139 */             GMeter.render(r, GMeter.C_BLUE, d, (RECTANGLE)this.body);
/*     */           } 
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 144 */           text.title(Dic.¤¤Balance);
/*     */         }
/*     */       };
/*     */     
/* 148 */     s.addDownC(4, (RENDEROBJ)hoverableAbs);
/* 149 */     s.addC((SPRITE)(UI.icons()).l.rebel, s.body().cX(), s.body().cY());
/*     */     
/* 151 */     int y1 = s.body().cY() - 12;
/*     */     
/* 153 */     s.add((RENDEROBJ)(new GStat((UI.FONT()).M)
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 158 */             GFORMAT.iBig(text, ((WBattleSide)player.get()).men());
/* 159 */             text.normalify2();
/*     */           }
/* 161 */         }).r(DIR.NE), s.body().x1() - 80, y1);
/*     */     
/* 163 */     s.add((RENDEROBJ)(new GStat((UI.FONT()).M)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 167 */             GFORMAT.iBig(text, ((WBattleSide)enemy.get()).men());
/* 168 */             text.warnify();
/*     */           }
/* 170 */         }).r(DIR.NW), s.body().x2() + 80, y1);
/*     */     
/* 172 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   void setCas(boolean hovRetreat, boolean hovFight) {
/* 177 */     this.hovRetreat = hovRetreat;
/* 178 */     this.hovAuto = hovFight;
/*     */   }
/*     */   
/*     */   GuiSection get(WBattleSpec spec) {
/* 182 */     this.g = spec;
/* 183 */     return this.sec;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection side(final GETTER<WBattleSide> g, final GMeter.GMeterCol col) {
/* 189 */     GuiSection s = new GuiSection();
/*     */ 
/*     */     
/* 192 */     HOVERABLE.HoverableAbs h = new HOVERABLE.HoverableAbs(300, 16)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 196 */           int am = 0;
/* 197 */           for (int i = 0; i < AD.supplies().arts().size(); i++) {
/* 198 */             am += ((WBattleSide)g.get()).artillery((ADSupplies.ADArtillery)AD.supplies().arts().get(i));
/*     */           }
/*     */           
/* 201 */           if (am <= 0) {
/*     */             return;
/*     */           }
/* 204 */           int d = (body().width() - 50) / am;
/* 205 */           d = CLAMP.i(d, 1, 16);
/*     */           
/* 207 */           int j = 0;
/* 208 */           for (ADSupplies.ADArtillery a : AD.supplies().arts()) {
/* 209 */             for (int k = 0; k < ((WBattleSide)g.get()).artillery(a); k++) {
/* 210 */               a.art.icon.small.render(r, this.body.x1() + j * d, body().y1());
/* 211 */               j++;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 219 */           GBox b = (GBox)text;
/* 220 */           for (int i = 0; i < AD.supplies().arts().size(); i++) {
/* 221 */             ADSupplies.ADArtillery a = (ADSupplies.ADArtillery)AD.supplies().arts().get(i);
/* 222 */             int am = ((WBattleSide)g.get()).artillery(a);
/* 223 */             if (am > 0) {
/* 224 */               b.add(((ADSupplies.ADArtillery)AD.supplies().arts().get(i)).art.icon.small);
/* 225 */               b.text(a.art.info.names);
/* 226 */               b.tab(7);
/* 227 */               b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 228 */               b.NL();
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 234 */     s.addDownC(0, (RENDEROBJ)h);
/*     */ 
/*     */     
/* 237 */     s.addDown(4, (RENDEROBJ)new Row(g, null, col));
/*     */     
/* 239 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 243 */           return ((WBattleSide)g.get()).units().size() - 1;
/*     */         }
/*     */       };
/*     */     
/* 247 */     bu.column(null, 300, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 251 */             return (RENDEROBJ)new Battle.Row(g, ier, col);
/*     */           }
/*     */         });
/*     */     
/* 255 */     s.addDown(8, (RENDEROBJ)bu.create(4, false));
/*     */     
/* 257 */     SPRITE frame = GCOLOR.UI().border().makeFrame(s.body().width() + 12, s.body().height() + 12, 1);
/*     */     
/* 259 */     s.addC(frame, s.body().cX(), s.body().cY());
/*     */     
/* 261 */     return s;
/*     */   }
/*     */   
/*     */   private class Row extends HOVERABLE.HoverableAbs {
/*     */     private final GETTER<WBattleSide> g;
/*     */     private final GETTER<Integer> ier;
/*     */     private final GMeter.GMeterCol col;
/*     */     
/*     */     Row(GETTER<WBattleSide> g, GETTER<Integer> ier, GMeter.GMeterCol col) {
/* 270 */       super(300, 24);
/* 271 */       this.g = g;
/* 272 */       this.ier = ier;
/* 273 */       this.col = col;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 279 */       WBattleUnit u = u();
/* 280 */       if (u == null)
/*     */         return; 
/* 282 */       u.icon().renderCY(r, this.body.x1(), this.body.cY());
/*     */       
/* 284 */       int X1 = this.body.x1() + 24 + 4;
/* 285 */       int WI = this.body.x2() - X1 - 8;
/*     */ 
/*     */       
/* 288 */       double dmen = Math.sqrt(u.men() / (Config.battle()).MEN_PER_ARMY);
/* 289 */       int X2 = (int)(X1 + WI * dmen);
/*     */       
/* 291 */       int losses = 0;
/*     */       
/* 293 */       if (Battle.this.hovRetreat)
/* 294 */         losses = u.lossesRetreat(); 
/* 295 */       if (Battle.this.hovAuto) {
/* 296 */         losses = u.losses();
/*     */       }
/*     */       
/* 299 */       double d = (u.men() - losses) / u.men();
/*     */       
/* 301 */       GMeter.render(r, this.col, d, X1, X2, this.body.y1() + 2, this.body.y2() - 2);
/*     */       
/* 303 */       GMeter.renderDelta(r, 1.0D, d, X1, X2, this.body.y1() + 2, this.body.y2() - 2, this.col);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 315 */       WBattleUnit u = u();
/* 316 */       if (u == null)
/*     */         return; 
/* 318 */       u.hover(text);
/* 319 */       super.hoverInfoGet(text);
/*     */       
/* 321 */       if (u.defences() >= 1.0D) {
/* 322 */         GBox b = (GBox)text;
/* 323 */         b.sep();
/* 324 */         b.text(Battle.¤¤defence);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private WBattleUnit u() {
/* 330 */       WBattleSide s = (WBattleSide)this.g.get();
/* 331 */       if (s == null)
/* 332 */         return null; 
/* 333 */       int ui = (this.ier == null) ? 0 : (((Integer)this.ier.get()).intValue() + 1);
/* 334 */       WBattleUnit u = (WBattleUnit)s.units().get(ui);
/* 335 */       if (u == null)
/* 336 */         return null; 
/* 337 */       return u;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class Butt
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     public Butt(SPRITE icon, CharSequence label) {
/* 346 */       super(label);
/* 347 */       icon((SPRITE)(UI.icons()).s.arrow_left);
/* 348 */       this.body.setWidth(200.0D);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Battle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */