/*     */ package view.ui.profile;
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class Titles extends GuiSection {
/*  36 */   private static CharSequence ¤¤spent = "¤Chosen";
/*  37 */   private static CharSequence ¤¤NotAchiving = "¤Titles can not be unlocked.";
/*  38 */   private static CharSequence ¤¤spentD = "¤Whenever you start a new game, you get to choose 5 unlocked titles.";
/*     */   
/*  40 */   private static CharSequence ¤¤Locked = "¤Title is currently unavailable.";
/*  41 */   private static CharSequence ¤¤Active = "¤Title is currently unlocked and active.";
/*  42 */   private static CharSequence ¤¤Unlocked = "¤Title is currently unlocked. You can select it when starting a new game.";
/*     */   static {
/*  44 */     D.ts(Titles.class);
/*     */   }
/*     */ 
/*     */   
/*     */   Titles(int HEIGHT) {
/*  49 */     addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  53 */             GFORMAT.iofk(text, (FACTIONS.player()).titles.selected(), 5L);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  58 */             b.text(Titles.¤¤spentD);
/*     */           }
/*  60 */         }).hh(¤¤spent));
/*     */     
/*  62 */     if (!GAME.achieving()) {
/*  63 */       addRelBody(4, DIR.S, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  67 */               if (!GAME.achieving()) {
/*  68 */                 text.errorify().add(Titles.¤¤NotAchiving);
/*     */               }
/*     */             }
/*     */           });
/*     */     }
/*     */     
/*  74 */     final StringInputSprite filter = (new StringInputSprite(18, (UI.FONT()).M)).placeHolder(Dic.¤¤Search);
/*     */     
/*  76 */     addRelBody(8, DIR.S, (RENDEROBJ)new GInput(filter));
/*     */ 
/*     */     
/*  79 */     ArrayList<RENDEROBJ> rows = new ArrayList((FACTIONS.player()).titles.all().size());
/*     */ 
/*     */     
/*  82 */     for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/*  83 */       rows.add(new Butt(t));
/*     */     }
/*     */     
/*  86 */     int hi = HEIGHT - body().height() - 16;
/*  87 */     hi = ((RENDEROBJ)rows.get(0)).body().height() * hi / ((RENDEROBJ)rows.get(0)).body().height();
/*     */     
/*  89 */     addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, hi)
/*     */         {
/*     */           protected boolean passesFilter(int i, RENDEROBJ o)
/*     */           {
/*  93 */             if (filter.text().length() > 0)
/*  94 */               return Str.containsText(((Titles.Butt)o).title.name, (CharSequence)filter.text()); 
/*  95 */             return true;
/*     */           }
/*  98 */         }).view());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Butt
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final PTitles.PTitle title;
/*     */ 
/*     */ 
/*     */     
/* 111 */     private final GuiSection sec = new GuiSection();
/*     */ 
/*     */     
/* 114 */     private GText t = new GText((UI.FONT()).H2, 24);
/*     */     Butt(final PTitles.PTitle title) {
/* 116 */       this.body.setDim(800.0D, (title.icon.height() * 2 + 16));
/* 117 */       this.title = title;
/* 118 */       int wi = 784 - title.icon.width() * 2 - 8;
/* 119 */       this.t.setMaxWidth(wi);
/* 120 */       this.t.set(title.name);
/*     */       
/* 122 */       this.sec.add((SPRITE)this.t, 0, 0);
/* 123 */       this.sec.addDown(4, (RENDEROBJ)new RENDEROBJ.RenderImp(wi, 12)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 127 */               GMeter.GMeterCol cc = GMeter.C_ORANGE;
/* 128 */               if (title.selected()) {
/* 129 */                 cc = GMeter.C_BLUE;
/* 130 */               } else if (title.unlocked()) {
/* 131 */                 cc = GMeter.C_GREEN;
/* 132 */               }  double d = 0.0D;
/* 133 */               if (title.unlocked() || title.race(FACTIONS.player().race())) {
/* 134 */                 d = 1.0D;
/*     */               } else {
/* 136 */                 d = title.lockable.progress(FACTIONS.player());
/*     */               } 
/* 138 */               GMeter.render(r, cc, d, (RECTANGLE)body());
/*     */             }
/*     */           });
/*     */       
/* 142 */       this.sec.addRelBody(8, DIR.W, (RENDEROBJ)new RENDEROBJ.RenderImp(title.icon.width() * 2, title.icon.height() * 2)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 146 */               if (!title.selected() && (!title.unlocked() || !title.race(FACTIONS.player().race())))
/* 147 */                 (GCOLOR.T()).INACTIVE.bind(); 
/* 148 */               title.icon.render(r, (RECTANGLE)this.body);
/* 149 */               COLOR.unbind();
/*     */               
/* 151 */               int x1 = Titles.Butt.this.body.x2() - 40;
/* 152 */               int y1 = Titles.Butt.this.body.y1() + 16;
/*     */               
/* 154 */               for (Race ra : RACES.playable()) {
/* 155 */                 if (title.race(ra)) {
/* 156 */                   (ra.appearance()).icon.render(r, x1, y1);
/* 157 */                   x1 -= 38;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 168 */       GButt.ButtPanel.renderBG(r, this.title.unlocked(), this.title.isNew(), this.title.selected(), (RECTANGLE)this.body);
/* 169 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       
/* 171 */       this.sec.body().centerIn((RECTANGLE)this.body);
/* 172 */       this.sec.render(r, ds);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 180 */       this.title.consumeNew();
/* 181 */       GBox b = (GBox)text;
/* 182 */       b.title(this.title.name);
/* 183 */       b.text(this.title.desc);
/* 184 */       b.NL(6);
/*     */       
/* 186 */       if (this.title.selected()) {
/* 187 */         b.text(Titles.¤¤Active);
/* 188 */       } else if (this.title.unlocked()) {
/* 189 */         b.text(Titles.¤¤Unlocked);
/*     */       } else {
/* 191 */         b.text(Titles.¤¤Locked);
/*     */       } 
/* 193 */       b.NL(6);
/* 194 */       this.title.lockable.hover(text, FACTIONS.player());
/*     */       
/* 196 */       b.sep();
/*     */       
/* 198 */       this.title.lockers.hover(text);
/* 199 */       b.NL(8);
/*     */       
/* 201 */       this.title.boosters.hover(text, Math.max(0.5D, this.title.boosterValue()), -1);
/*     */       
/* 203 */       if ((S.get()).developer && MButt.WHEEL.consumeClick())
/* 204 */         (FACTIONS.player()).titles.unlock(this.title); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\Titles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */