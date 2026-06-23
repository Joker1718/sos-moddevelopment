/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PLevels;
/*     */ import game.faction.player.PTitles;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.value.Lock;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Level extends GuiSection {
/*  34 */   private final CharSequence ¤¤Title = "¤{0} {1} of {2}";
/*     */   
/*     */   public Level(int height) {
/*  37 */     D.t(this);
/*     */     
/*  39 */     GTextR title = (new GTextR((new GText((UI.FONT()).H1, 64)).lablify())
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  42 */           text().clear();
/*  43 */           text().add(Level.this.¤¤Title);
/*  44 */           text().insert(0, FACTIONS.player().level().current().name());
/*  45 */           text().insert(1, FACTIONS.player().rulerName());
/*  46 */           text().insert(2, (CharSequence)(FACTIONS.player()).name);
/*  47 */           text().adjustWidth();
/*  48 */           super.render(r, ds, isHovered);
/*     */         }
/*  50 */       }).setAlign(DIR.N);
/*  51 */     add((RENDEROBJ)title);
/*     */     
/*  53 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(720, 64)
/*     */       {
/*  55 */         private final GText text = new GText((UI.FONT()).M, 200);
/*  56 */         private final GText tmp = new GText((UI.FONT()).M, 200);
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  60 */           this.text.clear();
/*     */           
/*  62 */           int y1 = body().y1() + this.text.height() / 2;
/*     */           
/*  64 */           for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/*  65 */             if (t.selected()) {
/*  66 */               this.tmp.set((CharSequence)this.text);
/*  67 */               if (this.text.width() > 0 && this.tmp.width() + this.text.width() > body().width()) {
/*  68 */                 this.text.renderC(r, body().cX(), y1);
/*  69 */                 this.text.clear();
/*  70 */                 this.text.add(t.name);
/*  71 */                 this.text.adjustWidth();
/*  72 */                 y1 += this.text.height(); continue;
/*     */               } 
/*  74 */               if (this.text.width() > 0)
/*  75 */                 this.text.add(',').s(); 
/*  76 */               this.text.add(t.name);
/*  77 */               this.text.adjustWidth();
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  86 */           if (this.text.width() > 0) {
/*  87 */             this.text.renderC(r, body().cX(), y1 + this.text.height() / 2);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  94 */     addDownC(8, (RENDEROBJ)renderImp);
/*     */     
/*  96 */     GuiSection stats = new GuiSection();
/*     */ 
/*     */     
/*  99 */     stats.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 103 */             GFORMAT.i(text, POP.tot(HCLASSES.CITIZEN(), null));
/*     */           }
/* 105 */         }).hv((HCLASSES.CITIZEN()).names));
/*     */     
/* 107 */     stats.addRightCAbs(120, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 111 */             GFORMAT.i(text, POP.tot(null));
/*     */           }
/* 113 */         }).hv(Dic.¤¤Population));
/*     */ 
/*     */     
/* 116 */     stats.addRightCAbs(120, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 120 */             GFORMAT.i(text, (POP.tot(null) + (RD.RACES()).population.faction().get(FACTIONS.player()) - (RD.RACES()).population.get(FACTIONS.player().realm().capitol())));
/*     */           }
/* 122 */         }).hv(Dic.¤¤Subjects));
/*     */     
/* 124 */     addRelBody(0, DIR.S, (RENDEROBJ)stats);
/*     */ 
/*     */     
/* 127 */     RENDEROBJ[] rens = new RENDEROBJ[GAME.player().level().all().size()];
/* 128 */     for (int i = 0; i < rens.length; i++) {
/* 129 */       rens[i] = (RENDEROBJ)new TRow((PLevels.Level)GAME.player().level().all().get(i));
/*     */     }
/*     */     
/* 132 */     int h = height - getLastY2() - 16;
/* 133 */     int am = h / rens[0].body().height();
/* 134 */     h = am * rens[0].body().height();
/*     */     
/* 136 */     CLICKABLE cLICKABLE = (new GScrollRows(rens, h, 0)).view();
/*     */     
/* 138 */     addDownC(8, (RENDEROBJ)cLICKABLE);
/*     */   }
/*     */   
/*     */   private class TRow
/*     */     extends GuiSection {
/*     */     PLevels.Level l;
/*     */     
/*     */     TRow(PLevels.Level l) {
/* 146 */       this.l = l;
/*     */       
/* 148 */       int w = 500;
/*     */       
/* 150 */       add((RENDEROBJ)new GHeader(l.name()));
/*     */       
/* 152 */       body().setWidth(w);
/*     */       
/* 154 */       GuiSection s = new GuiSection();
/*     */       
/* 156 */       for (BoostSpec b : l.boosters.all()) {
/* 157 */         s.addRightC(2, (SPRITE)b.boostable.icon);
/* 158 */         if (s.body().width() + s.getLast().width() >= w - body().width())
/*     */           break; 
/*     */       } 
/* 161 */       s.body().moveX2(w);
/* 162 */       s.body().moveCY(body().cY());
/* 163 */       absorb(s);
/*     */ 
/*     */       
/* 166 */       s = new GuiSection();
/* 167 */       s.body().setHeight(32.0D);
/* 168 */       for (Lock<?> b : (Iterable<Lock<?>>)l.lockers.all()) {
/* 169 */         s.addRightC(8, b.lockable.icon);
/* 170 */         if (s.body().width() + s.getLast().width() >= w) {
/*     */           break;
/*     */         }
/*     */       } 
/* 174 */       boolean f = true;
/* 175 */       for (BoostSpec b : l.boosters.all()) {
/* 176 */         s.addRightC(f ? 8 : 64, (RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 180 */                 b.booster.format(text, b.booster.to());
/*     */               }
/* 182 */             }).hh(b.boostable.icon.big));
/* 183 */         f = false;
/* 184 */         if (s.body().width() + s.getLast().width() >= w) {
/*     */           break;
/*     */         }
/*     */       } 
/* 188 */       s.body().moveX1(body().x1());
/* 189 */       s.body().moveY1((body().y2() + 8));
/* 190 */       absorb(s);
/*     */       
/* 192 */       GText gText = new GText((UI.FONT()).H2, (CharSequence)GFORMAT.toNumeral(l.index() + 1));
/* 193 */       add((SPRITE)gText, -64, 0);
/*     */       
/* 195 */       pad(8);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 200 */       GCOLOR.UI().border().render(r, (RECTANGLE)body());
/* 201 */       GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -1);
/* 202 */       super.render(r, ds);
/* 203 */       if (this.l.index() > GAME.player().level().current().index()) {
/* 204 */         OPACITY.O50.bind();
/* 205 */         COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 206 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 213 */       this.l.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\Level.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */