/*     */ package game.faction.player;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import init.value.Lockers;
/*     */ import integrations.SteamAchieve;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.process.Proccesser;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.INFO;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.ui.message.MessageSection;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class PTitles
/*     */ {
/*     */   private final LIST<PTitle> titles;
/*  59 */   private int newAmount = 0;
/*     */   public final INFO info;
/*     */   public final BoostSpecs boosters;
/*     */   private final BoostCompound<PTitle> bos;
/*  63 */   private static CharSequence ¤¤name = "Titles";
/*  64 */   private static CharSequence ¤¤desc = "Titles are unlocked by various achievements. At the start of each game, you may choose 5 of these unlocked titles to be associated with your name and boost your kingdom in various ways.";
/*  65 */   private static CharSequence ¤¤title = "Title Unlocked";
/*  66 */   private static CharSequence ¤¤titleD = "Congratulations, you've now earned the right to style yourself '{0}'!.";
/*  67 */   private static CharSequence ¤¤titleDD = "In your next play-through, or resettle, you will be allowed to select this title to boost your game.";
/*     */   
/*  69 */   public static CharSequence ¤¤racesUnlocked = "Races unlocked";
/*  70 */   public static CharSequence ¤¤racesUnlockedD = "Each race you unlock this title with will make its boosts more potent by an additional +{0}%.";
/*  71 */   public static CharSequence ¤¤currentBoost = "Current Boost"; final SAVABLE saver; double ddd;
/*     */   static {
/*  73 */     D.ts(PTitles.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PTitles() throws IOException {
/* 200 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 204 */           file.i(PTitles.this.titles.size());
/* 205 */           for (PTitles.PTitle t : PTitles.this.titles) {
/* 206 */             file.bool(t.isNew);
/* 207 */             file.bool(t.selected);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 215 */           for (PTitles.PTitle t : PTitles.this.titles) {
/* 216 */             t.isNew = false;
/* 217 */             t.selected = false;
/*     */           } 
/*     */           
/* 220 */           int am = file.i();
/* 221 */           for (int i = 0; i < am; i++) {
/* 222 */             boolean n = file.bool();
/* 223 */             boolean s = file.bool();
/* 224 */             if (i < PTitles.this.titles.size()) {
/* 225 */               PTitles.PTitle t = (PTitles.PTitle)PTitles.this.titles.get(i);
/* 226 */               t.isNew = n;
/* 227 */               t.selected = s;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 232 */           PTitles.this.bos.clearChache();
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 237 */           for (PTitles.PTitle t : PTitles.this.titles) {
/* 238 */             t.isNew = false;
/* 239 */             t.selected = false;
/*     */           } 
/* 241 */           PTitles.this.bos.clearChache();
/*     */         }
/*     */       };
/*     */     
/* 245 */     this.ddd = 0.0D; this.info = new INFO(¤¤name, ¤¤desc); PATH data = PATHS.INIT().getFolder("player").getFolder("titles"); PATH text = PATHS.TEXT().getFolder("player").getFolder("titles"); IconMaker mm = new IconMaker(); String[] ss = data.getFiles(); ArrayList<PTitle> all = new ArrayList(ss.length); byte b; int i; String[] arrayOfString1; for (i = (arrayOfString1 = ss).length, b = 0; b < i; ) { String s = arrayOfString1[b]; Json j = new Json(data.gets(s)); Json t = new Json(text.gets(s)); b++; }  this.titles = (LIST<PTitle>)all; KeyMap<PTitle> map = new KeyMap(); for (PTitle t : all) map.put(t.key, t);  try { if ((PATHS.local()).PROFILE.exists("Titles")) { Json j = new Json((PATHS.local()).PROFILE.gets("Titles")); if (j.has("UNLOCKED")) { String[] sss = j.values("UNLOCKED"); byte b1; int k; String[] arrayOfString2; for (k = (arrayOfString2 = sss).length, b1 = 0; b1 < k; ) { String s = arrayOfString2[b1]; if (map.containsKey(s)) ((PTitle)map.get(s)).unlocked = true;  b1++; }  }  }  } catch (Exception e) { e.printStackTrace(); GAME.Notify("old one didn't load"); }  try { Json j = new Json((PATHS.local()).PROFILE.gets("Titles2")); for (String k : j.keys()) { if (map.containsKey(k)) { PTitle t = (PTitle)map.get(k); String[] rr = j.values(k); t.unlocked = true; byte b1; int m; String[] arrayOfString2; for (m = (arrayOfString2 = rr).length, b1 = 0; b1 < m; ) { String r = arrayOfString2[b1]; Race race = (Race)RACES.map().tryGet(r); if (race != null) { t.races[race.index] = true; t.raceValue++; }  b1++; }  }  }  } catch (Exception e) { GAME.Notify("resetting"); saveUnlocked(); }  this.boosters = new BoostSpecs(¤¤name, (SPRITE)(UI.icons()).s.chevron(DIR.N), true); this.bos = new BoostCompound<PTitle>(this.boosters, this.titles) { protected double getValue(PTitles.PTitle t) { return t.selected ? (0.5D + 0.5D * t.raceValue / RACES.playable().size()) : 0.0D; } protected BoostSpecs bos(PTitles.PTitle t) { return t.boosters; } protected double get(Boostable bo, FactionNPC f, boolean isMul) { return 0.0D; } }
/*     */       ; IDebugPanel.add("STEAM ACHIEVE", new ACTION() { public void exe() { if ((PATHS.isSteam() || PATHS.isDevelop()) && (PATHS.local()).PROFILE.exists("Titles2")) PTitles.achieve();  } }
/*     */       ); IDebugPanel.add("STEAM ACHIEVE_ALL", new ACTION() { public void exe() { if ((PATHS.isSteam() || PATHS.isDevelop()) && (PATHS.local()).PROFILE.exists("Titles2")) { String[] ss = new String[PTitles.this.all().size()]; for (int i = 0; i < ss.length; i++) ss[i] = ((PTitles.PTitle)PTitles.this.all().get(i)).key;  Proccesser.exec(SteamAchieve.class, new String[0], ss, new String[0]); }  } }); IDebugPanel.add("STEAM ACHIEVE_CLEAR", new ACTION() { public void exe() { if ((PATHS.isSteam() || PATHS.isDevelop()) && (PATHS.local()).PROFILE.exists("Titles2")) Proccesser.exec(SteamAchieve.class, new String[0], new String[0], new String[0]);  } });
/* 248 */   } void update(double ds) { if (!GAME.achieving()) {
/*     */       return;
/*     */     }
/* 251 */     int o = (int)this.ddd;
/* 252 */     this.ddd += ds;
/* 253 */     int n = (int)this.ddd;
/* 254 */     if (o == n)
/*     */       return; 
/* 256 */     if (n >= this.titles.size()) {
/* 257 */       this.ddd = 0.0D;
/* 258 */       n = 0;
/*     */     } 
/*     */     
/* 261 */     PTitle t = (PTitle)this.titles.get(n);
/* 262 */     if ((!t.unlocked || !t.race(FACTIONS.player().race())) && t.unlockable()) {
/* 263 */       t.timer += this.titles.size();
/* 264 */       if (t.timer > TIME.secondsPerDay() * 0.25D) {
/* 265 */         unlock(t);
/*     */       }
/*     */     } else {
/*     */       
/* 269 */       t.timer = 0.0D;
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unlock(PTitle t) {
/* 275 */     t.isNew = true;
/* 276 */     t.unlocked = true;
/*     */     
/* 278 */     t.races[(FACTIONS.player().race()).index] = true;
/* 279 */     t.raceValue++;
/* 280 */     (new Message(t)).send();
/* 281 */     saveUnlocked();
/*     */   }
/*     */   
/*     */   public int selected() {
/* 285 */     int am = 0;
/* 286 */     for (PTitle t : this.titles) {
/* 287 */       if (t.selected)
/* 288 */         am++; 
/*     */     } 
/* 290 */     return am;
/*     */   }
/*     */   
/*     */   public int unlocked() {
/* 294 */     int am = 0;
/* 295 */     for (PTitle t : this.titles) {
/* 296 */       if (t.unlocked)
/* 297 */         am++; 
/*     */     } 
/* 299 */     return am;
/*     */   }
/*     */   
/*     */   public boolean hasNew() {
/* 303 */     return (this.newAmount > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void saveUnlocked() {
/*     */     try {
/* 310 */       KeyMap<KeyMap<String>> all = new KeyMap();
/* 311 */       for (PTitle t : this.titles) {
/* 312 */         if (t.unlocked) {
/* 313 */           KeyMap<String> ss = new KeyMap();
/* 314 */           for (Race r : RACES.all()) {
/* 315 */             if (t.race(r))
/* 316 */               ss.put(r.key, r.key); 
/*     */           } 
/* 318 */           all.put(t.key, ss);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 323 */       if ((PATHS.local()).PROFILE.exists("Titles2")) {
/* 324 */         Json old = new Json((PATHS.local()).PROFILE.gets("Titles2"));
/*     */         
/* 326 */         for (String s : old.keys()) {
/* 327 */           if (!all.containsKey(s))
/* 328 */             all.put(s, new KeyMap());  byte b; int i;
/*     */           String[] arrayOfString;
/* 330 */           for (i = (arrayOfString = old.values(s)).length, b = 0; b < i; ) { String r = arrayOfString[b];
/* 331 */             ((KeyMap)all.get(s)).putReplace(r, s);
/*     */             b++; }
/*     */         
/*     */         } 
/*     */       } else {
/* 336 */         (PATHS.local()).PROFILE.create("Titles2");
/*     */       } 
/*     */       
/* 339 */       JsonE to = new JsonE();
/*     */       
/* 341 */       for (String tkey : all.keysSorted()) {
/* 342 */         KeyMap<String> race = (KeyMap<String>)all.get(tkey);
/* 343 */         to.add(tkey, race.keysSorted());
/*     */       } 
/*     */       
/* 346 */       to.save((PATHS.local()).PROFILE.get("Titles2"));
/* 347 */     } catch (Exception e) {
/* 348 */       e.printStackTrace(System.out);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void achieve() {
/* 354 */     if (PATHS.isSteam() && (PATHS.local()).PROFILE.exists("Titles2")) {
/* 355 */       Json old = new Json((PATHS.local()).PROFILE.gets("Titles2"));
/* 356 */       String[] sss = new String[old.keys().size()];
/* 357 */       int i = 0;
/* 358 */       for (String k : old.keys()) {
/* 359 */         sss[i++] = k;
/*     */       }
/* 361 */       Proccesser.exec(SteamAchieve.class, new String[0], sss, new String[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PTitle> all() {
/* 369 */     return this.titles;
/*     */   }
/*     */   
/*     */   public static final class PTitle
/*     */     extends INFO implements INDEXED {
/* 374 */     private double timer = 0.0D;
/*     */     
/*     */     private final int index;
/*     */     public final Lockers lockers;
/*     */     public final Lockable<Faction> lockable;
/*     */     public final BoostSpecs boosters;
/*     */     public final SPRITE icon;
/*     */     private final String key;
/*     */     private boolean selected;
/*     */     private boolean isNew;
/*     */     private boolean unlocked;
/* 385 */     private boolean[] races = new boolean[RACES.all().size()];
/* 386 */     private double raceValue = 0.0D;
/*     */     
/*     */     PTitle(String key, LISTE<PTitle> all, Json jdata, Json jtext, PTitles.IconMaker iconM) throws IOException {
/* 389 */       super(jtext);
/* 390 */       this.key = key;
/* 391 */       this.index = all.add(this);
/*     */       
/* 393 */       this.lockable = GVALUES.FACTION.LOCK.push();
/* 394 */       this.lockable.push(jdata);
/* 395 */       this.icon = iconM.get(jdata);
/* 396 */       this.lockers = new Lockers(String.valueOf(PTitles.¤¤name) + ": " + String.valueOf(PTitles.¤¤name), (SPRITE)(UI.icons()).s.chevron(DIR.N));
/* 397 */       this.lockers.add(GVALUES.FACTION, jdata, new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t)
/*     */             {
/* 401 */               if (t == FACTIONS.player()) {
/* 402 */                 return (PTitles.PTitle.this.selected ? true : false);
/*     */               }
/* 404 */               return 1.0D;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 409 */       this.lockers.add(GVALUES.INDU, jdata, new DOUBLE_O<Induvidual>()
/*     */           {
/*     */             public double getD(Induvidual t)
/*     */             {
/* 413 */               if (t.faction() == FACTIONS.player()) {
/* 414 */                 return (PTitles.PTitle.this.selected ? true : false);
/*     */               }
/* 416 */               return 1.0D;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 421 */       this.lockers.add(GVALUES.REGION, jdata, new DOUBLE_O<Region>()
/*     */           {
/*     */             public double getD(Region t)
/*     */             {
/* 425 */               if (t.faction() == FACTIONS.player()) {
/* 426 */                 return (PTitles.PTitle.this.selected ? true : false);
/*     */               }
/* 428 */               return 1.0D;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 433 */       this.boosters = new BoostSpecs(this.name, (SPRITE)(UI.icons()).s.chevron(DIR.N), false);
/* 434 */       this.boosters.read(jdata, null);
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 439 */       return this.index;
/*     */     }
/*     */     
/*     */     public void select(boolean s) {
/* 443 */       if (s == this.selected)
/*     */         return; 
/* 445 */       this.selected = s;
/* 446 */       (FACTIONS.player()).titles.bos.clearChache();
/*     */     }
/*     */     
/*     */     public boolean selected() {
/* 450 */       return this.selected;
/*     */     }
/*     */     
/*     */     private boolean unlockable() {
/* 454 */       return this.lockable.passes(FACTIONS.player());
/*     */     }
/*     */     
/*     */     public boolean unlocked() {
/* 458 */       return !(!this.unlocked && !unlockable());
/*     */     }
/*     */     
/*     */     public boolean isNew() {
/* 462 */       return this.isNew;
/*     */     }
/*     */     
/*     */     public void consumeNew() {
/* 466 */       this.isNew = false;
/*     */     }
/*     */     
/*     */     public boolean race(Race r) {
/* 470 */       return this.races[r.index()];
/*     */     }
/*     */     
/*     */     public double boosterValue() {
/* 474 */       if (this.unlocked || this.selected)
/* 475 */         return 0.5D + 0.5D * this.raceValue / RACES.playable().size(); 
/* 476 */       return 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class IconMaker
/*     */   {
/* 483 */     private final int WW = 5;
/* 484 */     private static int txs = 6;
/* 485 */     private static int tys = 4;
/*     */     
/* 487 */     public static int WIDTH = txs * 8;
/* 488 */     public static int HEIGHT = tys * 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SPRITE get(Json json) throws IOException {
/* 504 */       int ii = json.i("ICON_I");
/* 505 */       return get(ii);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private SPRITE get(final int ii) throws IOException {
/* 512 */       final TILE_SHEET s = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 516 */             s.full2.setVar(ii);
/* 517 */             s.full2.paste(true);
/* 518 */             return d.s8.saveGui();
/*     */           }
/* 520 */         }).get();
/*     */       
/* 522 */       return (SPRITE)new SPRITE.Imp(txs * 8, tys * 8)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 527 */             int w = (X2 - X1) / PTitles.IconMaker.txs;
/* 528 */             int h = (Y2 - Y1) / PTitles.IconMaker.tys;
/* 529 */             int y = Y1;
/* 530 */             int i = 0;
/* 531 */             for (int dy = 0; dy < PTitles.IconMaker.tys; dy++) {
/* 532 */               int x = X1;
/* 533 */               for (int dx = 0; dx < PTitles.IconMaker.txs; dx++) {
/* 534 */                 s.render(r, i, x, x + w, y, y + h);
/* 535 */                 x += w;
/* 536 */                 i++;
/*     */               } 
/*     */               
/* 539 */               y += h;
/*     */             } 
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE[] all() throws IOException {
/* 547 */       SPRITE[] sprites = new SPRITE[35];
/* 548 */       for (int i = 0; i < sprites.length; i++) {
/* 549 */         sprites[i] = get(i);
/*     */       }
/* 551 */       return sprites;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Message
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final String tkey;
/*     */ 
/*     */     
/*     */     public Message(PTitles.PTitle t) {
/* 565 */       super(PTitles.¤¤title);
/* 566 */       this.tkey = t.key;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 571 */       final PTitles.PTitle t = get();
/* 572 */       if (t == null) {
/*     */         return;
/*     */       }
/* 575 */       paragraph(t.desc);
/*     */       
/* 577 */       GText tt = new GText((UI.FONT()).S, PTitles.¤¤titleD);
/* 578 */       tt.normalify2();
/* 579 */       tt.insert(0, t.name);
/* 580 */       tt.setMaxWidth(900);
/* 581 */       tt.setMultipleLines(true);
/* 582 */       tt.adjustWidth();
/* 583 */       section.addRelBody(8, DIR.N, (SPRITE)tt);
/*     */       
/* 585 */       section.addRelBody(8, DIR.N, t.icon.scaled(4.0D));
/*     */       
/* 587 */       tt = new GText((UI.FONT()).S, PTitles.¤¤titleDD);
/* 588 */       tt.normalify2();
/* 589 */       tt.setMaxWidth(900);
/* 590 */       tt.setMultipleLines(true);
/* 591 */       tt.adjustWidth();
/* 592 */       section.addRelBody(8, DIR.S, (SPRITE)tt);
/*     */ 
/*     */       
/* 595 */       GHeader h = new GHeader(PTitles.¤¤racesUnlocked);
/* 596 */       section.addRelBody(8, DIR.S, (RENDEROBJ)h);
/* 597 */       GuiSection s = new GuiSection();
/* 598 */       for (Race r : RACES.playable()) {
/* 599 */         if (t.race(r))
/* 600 */           s.addRightC(8, (RENDEROBJ)(new HOVERABLE.Sprite((SPRITE)(r.appearance()).iconBig)).hoverTitleSet(r.info.names)); 
/*     */       } 
/* 602 */       section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */       
/* 604 */       tt = new GText((UI.FONT()).S, PTitles.¤¤racesUnlockedD);
/* 605 */       tt.insert(0, 50.0D / RACES.playable().size(), 1);
/* 606 */       tt.normalify2();
/* 607 */       tt.setMaxWidth(900);
/* 608 */       tt.setMultipleLines(true);
/* 609 */       tt.adjustWidth();
/* 610 */       section.addRelBody(4, DIR.S, (SPRITE)tt);
/*     */       
/* 612 */       h = new GHeader(PTitles.¤¤currentBoost);
/* 613 */       section.addRelBody(8, DIR.S, (RENDEROBJ)h);
/*     */ 
/*     */       
/* 616 */       int hi = 32 + 32 * t.boosters.all().size() / 2;
/*     */       
/* 618 */       section.addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(700, hi)
/*     */           {
/*     */             
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 623 */               GBox.tmp.clear();
/* 624 */               GBox.tmp.maxWidth = 700;
/* 625 */               GBox.tmp.maxHeight = 500;
/* 626 */               t.boosters.hover((GUI_BOX)GBox.tmp, t.boosterValue(), null, -1);
/* 627 */               GBox.tmp.renderWithout(r, this.body.x1(), this.body.y1());
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private PTitles.PTitle get() {
/* 635 */       for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/* 636 */         if (t.key.equals(this.tkey))
/* 637 */           return t; 
/*     */       } 
/* 639 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTitles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */