/*     */ package world.entity.haven;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAINS;
/*     */ import init.value.COMPARATOR;
/*     */ import init.value.GVALUES;
/*     */ import init.value.GValueCat;
/*     */ import init.value.Lockable;
/*     */ import init.value.Value;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WHavenType
/*     */   implements INDEXED
/*     */ {
/*     */   private final int index;
/*     */   public final TILE_SHEET sheet;
/*     */   public final COLOR cMask;
/*     */   public final LIST<CharSequence> names;
/*     */   public final CharSequence sJoin;
/*     */   public final CharSequence sLeave;
/*     */   public final Race race;
/*     */   public final int popFrom;
/*     */   public final int popTo;
/*     */   public final double replenishMin;
/*     */   public final double replenishMax;
/*     */   public final Lockable<Faction> reqsFrom;
/*     */   public final Lockable<Faction> reqsTo;
/*     */   public final double[] climates;
/*     */   public final double[] terrains;
/*  61 */   private ArrayListGrower<Delta> deltas = new ArrayListGrower();
/*  62 */   private ArrayListGrower<Gauge> gauges = new ArrayListGrower();
/*     */   
/*     */   WHavenType(String key, LISTE<WHavenType> all, Json jdata, Json jtext, TILE_SHEET sheet) throws IOException {
/*  65 */     this.index = all.add(this);
/*  66 */     this.sheet = sheet;
/*  67 */     this.cMask = (COLOR)new ColorImp(jdata, "COLOR_MASK");
/*  68 */     this.names = (LIST<CharSequence>)new ArrayList((Object[])jtext.texts("NAMES", 1, 500));
/*  69 */     this.sJoin = jtext.text("JOIN");
/*  70 */     this.sLeave = jtext.text("LEAVE");
/*     */     
/*  72 */     this.race = (Race)RACES.map().get(jdata.value("RACE"), jdata);
/*  73 */     this.climates = CLIMATES.MAP().readFill(jdata, 1.0D);
/*  74 */     this.terrains = TERRAINS.MAP().readFill(jdata, 100.0D);
/*  75 */     this.reqsFrom = GVALUES.FACTION.LOCK.push("WORLD_CAMP_" + key, this.race.info.names, this.race.info.names, (SPRITE)(this.race.appearance()).icon);
/*  76 */     this.reqsFrom.push("REQUIRES_MIN", jdata);
/*  77 */     this.reqsTo = GVALUES.FACTION.LOCK.push();
/*  78 */     this.reqsTo.push("REQUIRES_MAX", jdata);
/*     */     
/*  80 */     GVALUES.FACTION.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     GVALUES.FACTION.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.popFrom = jdata.i("CAMP_SIZE_FROM", 1, 1000);
/*  97 */     this.popTo = jdata.i("CAMP_SIZE_TO", this.popFrom, 1000);
/*     */     
/*  99 */     this.replenishMin = jdata.d("REPLENISH_PER_DAY_FROM");
/* 100 */     this.replenishMax = jdata.d("REPLENISH_PER_DAY_TO");
/*     */   }
/*     */ 
/*     */   
/*     */   private void add(boolean from, COMPARATOR comp, Value<Faction> value, double target) {
/* 105 */     for (Delta delta : this.deltas) {
/* 106 */       if (delta.comp == comp && delta.value == value) {
/* 107 */         if (from) {
/* 108 */           delta.from = target;
/*     */         } else {
/* 110 */           delta.to = target;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } 
/* 115 */     Delta d = new Delta();
/* 116 */     d.comp = comp;
/* 117 */     d.value = value;
/* 118 */     if (from) {
/* 119 */       d.from = target;
/*     */     } else {
/* 121 */       d.to = target;
/* 122 */     }  this.deltas.add(d);
/*     */     
/* 124 */     this.gauges.add(new Gauge(d));
/*     */   }
/*     */ 
/*     */   
/*     */   static LIST<WHavenType> types() throws IOException {
/* 129 */     LinkedList<WHavenType> all = new LinkedList();
/* 130 */     KeyMap<TILE_SHEET> sheets = new KeyMap();
/*     */     
/* 132 */     PATHS.ResFolder f = PATHS.RACE().folder("worldcamp"); byte b; int i;
/*     */     String[] arrayOfString;
/* 134 */     for (i = (arrayOfString = f.init.getFiles()).length, b = 0; b < i; ) { String file = arrayOfString[b];
/*     */       
/* 136 */       Json jdata = new Json(f.init.gets(file));
/* 137 */       Json jtext = new Json(f.text.gets(file));
/*     */       
/* 139 */       String ssprite = jdata.value("SPRITE");
/* 140 */       TILE_SHEET sheet = (TILE_SHEET)sheets.get(ssprite);
/* 141 */       if (sheet == null) {
/* 142 */         TILE_SHEET s = (new ComposerThings.ITileSheet(f.sprite.get(ssprite), 132, 126)
/*     */           {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */             {
/* 146 */               s.singles.init(0, 0, 1, 1, 2, 4, (ComposerDests.Dest)d.s24);
/* 147 */               s.singles.paste(3, true);
/* 148 */               return d.s24.saveGame();
/*     */             }
/* 150 */           }).get();
/* 151 */         sheets.put(ssprite, s);
/* 152 */         sheet = s;
/*     */       } 
/*     */       
/*     */       b++; }
/*     */     
/* 157 */     return (LIST<WHavenType>)new ArrayList((Iterable)all);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 163 */     return this.index;
/*     */   }
/*     */   private static class Delta { double from;
/*     */     
/*     */     private Delta() {
/* 168 */       this.from = Double.NaN;
/* 169 */       this.to = Double.NaN;
/*     */     }
/*     */     
/*     */     double to;
/*     */     COMPARATOR comp;
/*     */     Value<Faction> value; }
/*     */ 
/*     */   
/*     */   public double amount() {
/* 178 */     if (!this.reqsFrom.passes(FACTIONS.player())) {
/* 179 */       return 0.0D;
/*     */     }
/* 181 */     double d = 1.0D;
/* 182 */     int am = 0;
/*     */     
/* 184 */     for (Delta de : this.deltas) {
/*     */       
/* 186 */       if (de.to == Double.NaN) {
/*     */         continue;
/*     */       }
/* 189 */       double v = de.value.d.getD(FACTIONS.player());
/*     */       
/* 191 */       if (de.from != Double.NaN) {
/*     */ 
/*     */ 
/*     */         
/* 195 */         double zero = CLAMP.d(de.comp.progress(de.from, de.to), 0.0D, 1.0D);
/* 196 */         if (zero < 1.0D) {
/*     */ 
/*     */           
/* 199 */           double delta = 1.0D - zero;
/* 200 */           double vv = CLAMP.d(de.comp.progress(v, de.to), 0.0D, 1.0D);
/* 201 */           vv -= zero;
/* 202 */           vv /= delta;
/*     */           
/* 204 */           vv = CLAMP.d(vv, 0.0D, 1.0D);
/* 205 */           d += vv;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 212 */       am++;
/*     */     } 
/*     */     
/* 215 */     if (am > 0) {
/* 216 */       d /= am;
/*     */     }
/* 218 */     d = 0.2D + 0.8D * (int)Math.round(d * 5.0D) / 5.0D;
/*     */     
/* 220 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverProgress(GUI_BOX bb) {
/* 226 */     GBox b = (GBox)bb;
/* 227 */     for (Delta de : this.deltas) {
/*     */       
/* 229 */       if (de.to == Double.NaN) {
/*     */         continue;
/*     */       }
/* 232 */       double v = de.value.d.getD(FACTIONS.player());
/*     */       
/* 234 */       b.text(de.value.name);
/* 235 */       b.tab(6);
/* 236 */       b.add((SPRITE)GFORMAT.f(b.text(), v, 2));
/* 237 */       b.tab(8);
/* 238 */       b.add((SPRITE)b.text().add('/'));
/*     */       
/* 240 */       b.add((SPRITE)GFORMAT.f(b.text(), de.to, 2));
/* 241 */       b.NL();
/*     */     } 
/*     */     
/* 244 */     for (Gauge de : this.gauges) {
/* 245 */       b.add((SPRITE)de);
/* 246 */       b.NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double progress() {
/* 252 */     double d = 0.0D;
/* 253 */     int am = 0;
/* 254 */     for (Delta de : this.deltas) {
/*     */       
/* 256 */       am++;
/* 257 */       d += de.value.d.getD(FACTIONS.player());
/*     */     } 
/*     */     
/* 260 */     return d / am;
/*     */   }
/*     */   
/*     */   private class Gauge
/*     */     extends SPRITE.Imp {
/*     */     private final WHavenType.Delta de;
/*     */     
/*     */     Gauge(WHavenType.Delta delta) {
/* 268 */       super(128, 16);
/* 269 */       this.de = delta;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 274 */       double vv = 0.0D;
/* 275 */       double v = this.de.value.d.getD(FACTIONS.player());
/* 276 */       vv = this.de.comp.progress(v, this.de.to);
/* 277 */       vv = CLAMP.d(vv, 0.0D, 1.0D);
/* 278 */       GMeter.render(r, GMeter.C_BLUE, vv, X1, X2, Y1, Y2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\WHavenType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */