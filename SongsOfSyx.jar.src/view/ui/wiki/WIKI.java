/*     */ package view.ui.wiki;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import init.constant.C;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class WIKI extends Interrupter {
/*     */   public static final int TOP_HEIGHT = 0;
/*  31 */   public static final int WIDTH = C.WIDTH() - 32;
/*  32 */   public static final int HEIGHT = C.HEIGHT() - 16;
/*     */   
/*  34 */   private final GuiSection section = new GuiSection();
/*  35 */   public static CharSequence ¤¤name = "Tome of Knowledge";
/*     */   
/*  37 */   private static final ArrayList<Article> articles = new ArrayList(1024);
/*     */   private ArrayList<Article> added;
/*  39 */   private GuiSection sAdded = new GuiSection();
/*  40 */   private final Article[] race = new Article[RACES.all().size()];
/*     */   
/*     */   private final WikiList list;
/*  43 */   static final KeyMap<Article> links = new KeyMap();
/*     */   
/*     */   static {
/*  46 */     D.ts(WIKI.class);
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
/*     */   public static ACTION add(Json json) {
/*  58 */     if (!json.has("WIKI"))
/*  59 */       return null; 
/*  60 */     json = json.json("WIKI");
/*  61 */     return padd(json);
/*     */   }
/*     */   
/*     */   public static ACTION padd(Json json) {
/*  65 */     final ArticleText a = new ArticleText(json, links);
/*  66 */     articles.add(a);
/*  67 */     return new ACTION()
/*     */       {
/*     */         public void exe() {
/*  70 */           (VIEW.UI()).wiki.activate();
/*  71 */           (VIEW.UI()).wiki.set(a);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WIKI() {
/*  81 */     PATH p = PATHS.TEXT().getFolder("wiki");
/*  82 */     String[] files = p.getFiles(); byte b; int j; String[] arrayOfString1;
/*  83 */     for (j = (arrayOfString1 = files).length, b = 0; b < j; ) { String f = arrayOfString1[b];
/*  84 */       Json json = new Json(p.gets(f));
/*  85 */       if (json.has("WIKI")) {
/*  86 */         add(json);
/*     */       }
/*  88 */       if (json.has("WIKIS")) {
/*     */         
/*  90 */         Json[] arrayOfJson1 = json.jsons("WIKIS"); byte b1; int k; Json[] arrayOfJson2;
/*  91 */         for (k = (arrayOfJson2 = arrayOfJson1).length, b1 = 0; b1 < k; ) { Json jj = arrayOfJson2[b1];
/*  92 */           padd(jj);
/*     */           
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */       b++; }
/*     */     
/*  99 */     for (Race r : RACES.all()) {
/* 100 */       this.race[r.index()] = new WikiRace(r);
/* 101 */       articles.add(this.race[r.index()]);
/*     */     } 
/*     */     
/* 104 */     Tree<Article> sort = new Tree<Article>(articles.size())
/*     */       {
/*     */         protected boolean isGreaterThan(Article ce, Article c2) {
/* 107 */           return smaller(ce.key, c2.key);
/*     */         }
/*     */         
/*     */         boolean smaller(CharSequence current, CharSequence cmp) {
/* 111 */           for (int i = 0; i < current.length(); i++) {
/* 112 */             if (i >= cmp.length())
/* 113 */               return false; 
/* 114 */             if (current.charAt(i) > cmp.charAt(i))
/* 115 */               return false; 
/* 116 */             if (current.charAt(i) < cmp.charAt(i))
/* 117 */               return true; 
/*     */           } 
/* 119 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 123 */     for (Article a : articles) {
/* 124 */       sort.add(a);
/*     */     }
/* 126 */     articles.clearSloppy();
/* 127 */     while (sort.hasMore()) {
/* 128 */       articles.add(sort.pollGreatest());
/*     */     }
/* 130 */     this.list = new WikiList(articles, HEIGHT);
/*     */     
/* 132 */     this.section.add((RENDEROBJ)this.list, 0, 0);
/* 133 */     int x1 = this.section.getLastX2();
/* 134 */     this.section.add((RENDEROBJ)this.sAdded, this.section.getLastX2(), 0);
/*     */     
/* 136 */     int width = 600;
/* 137 */     int am = (WIDTH - x1) / 600;
/* 138 */     int ex = WIDTH - x1 - am * width;
/* 139 */     ex /= am;
/* 140 */     width += ex;
/*     */     
/* 142 */     this.added = new ArrayList(am);
/*     */     
/* 144 */     for (int i = 0; i < articles.size(); i++) {
/* 145 */       Article a = (Article)articles.get(i);
/* 146 */       a.init((LIST<Article>)articles, width);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 153 */     this.section.hover(mCoo);
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 159 */     if (button == MButt.RIGHT) {
/* 160 */       if (!back())
/* 161 */         hide(); 
/* 162 */     } else if (button == MButt.LEFT) {
/* 163 */       this.section.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 169 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 174 */     GAME.SPEED.tmpPause();
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 181 */     GCOLOR.UI().bg().render((SPRITE_RENDERER)r, C.DIM());
/* 182 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 189 */     super.hide();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean back() {
/* 195 */     if (this.added.size() > 0) {
/* 196 */       remove((Article)this.added.get(this.added.size() - 1));
/* 197 */       return true;
/*     */     } 
/* 199 */     return false;
/*     */   }
/*     */   
/*     */   public void activate() {
/* 203 */     this.added.clear();
/* 204 */     adjust();
/* 205 */     show((VIEW.inters()).manager);
/*     */   }
/*     */ 
/*     */   
/*     */   void remove(Article a) {
/* 210 */     this.added.removeOrdered(a);
/*     */     
/* 212 */     adjust();
/*     */   }
/*     */ 
/*     */   
/*     */   void set(Article a) {
/* 217 */     if (!this.added.isEmpty() && a == this.added.get(0)) {
/*     */       return;
/*     */     }
/* 220 */     if (this.added.contains(a)) {
/* 221 */       this.added.remove(a);
/*     */     }
/* 223 */     if (!this.added.hasRoom()) {
/* 224 */       this.added.removeLast();
/*     */     }
/* 226 */     this.added.insert(0, a);
/* 227 */     adjust();
/*     */   }
/*     */ 
/*     */   
/*     */   private void adjust() {
/* 232 */     int x = this.sAdded.body().x1();
/* 233 */     int y = this.sAdded.body().y1();
/* 234 */     this.sAdded.clear();
/*     */     
/* 236 */     for (Article aa : this.added) {
/* 237 */       this.sAdded.addRightC(0, (RENDEROBJ)aa.section);
/*     */     }
/* 239 */     this.sAdded.body().moveX1Y1(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void showRace(Race r) {
/* 244 */     activate();
/* 245 */     this.list.setList(this.race[r.index]);
/* 246 */     set(this.race[r.index]);
/*     */   }
/*     */   
/*     */   public LIST<Article> added() {
/* 250 */     return (LIST<Article>)this.added;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WIKI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */