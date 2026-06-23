/*     */ package view.world.generator.tools;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import init.race.Race;
/*     */ import init.resources.Minable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DOUBLE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.terrain.WorldTerrainInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIWorldToolCapitolPlaceInfo
/*     */ {
/*  36 */   private static CharSequence ¤¤moisture = "Moisture";
/*  37 */   private static CharSequence ¤¤moistureD = "High natural moisture spots have little need for additional irrigation, but more potential health risks.";
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static CharSequence ¤¤climate = "¤{0} do not prefer climate: {1}. It will be a bit harder to please them.";
/*  42 */   private static CharSequence ¤¤isolated = "¤This location is isolated. You will have less trade and less chance to forge an empire and have to rely more on your own production.";
/*  43 */   private static CharSequence ¤¤neigh = "¤You will have few of your own species nearby, which might make expanding harder in late game.";
/*     */   
/*     */   static {
/*  46 */     D.ts(UIWorldToolCapitolPlaceInfo.class);
/*     */   }
/*  48 */   private final GuiSection s = new GuiSection();
/*  49 */   private final WorldTerrainInfo info = new WorldTerrainInfo();
/*  50 */   private final WorldTerrainInfo area = new WorldTerrainInfo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final BOOLEANO<BoostSpec> filter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIWorldToolCapitolPlaceInfo()
/*     */   {
/*  79 */     this.filter = new BOOLEANO<BoostSpec>() {
/*     */         public void update(GText text) { text.add(((CLIMATE)(WORLD.CLIMATE()).getter.get(UIWorldToolCapitolPlaceInfo.this.info.tx, UIWorldToolCapitolPlaceInfo.this.info.ty)).name); }
/*     */       };
/*     */     int m = 170;
/*  83 */     this.s.addDown(0, (RENDEROBJ)(new GStat() { public boolean is(BoostSpec t) { return ((t.boostable.cat.typeMask & 0x4) != 0); } }).hh((CLIMATES.INFO()).name, m));
/*     */     this.s.addDown(2, (RENDEROBJ)new GHeader.HeaderHorizontal(Dic.¤¤Fertility, (SPRITE)new GMeter.GMeterSprite(GMeter.C_REDGREEN, (DOUBLE)this.info.fertility(), 64, 12), m));
/*     */     this.s.body().incrH(14.0D);
/*     */     for (TERRAIN t : TERRAINS.ALL()) {
/*     */       this.s.add(t.icon(), 0, this.s.body().y2() - 2);
/*     */       this.s.addRightC(4, (SPRITE)(new GText((UI.FONT()).S, t.name)).lablifySub());
/*     */       this.s.addCentredY((SPRITE)new GMeter.GMeterSprite(GMeter.C_ORANGE, (DOUBLE)this.info.get(t), 64, 12), m);
/*     */     } 
/*  91 */     this.s.body().incrW(48.0D); } public void placeInfo(GBox b, int tx1, int ty1, Race race) { this.info.initCity(tx1, ty1);
/*  92 */     int cx = tx1 + 1;
/*  93 */     int cy = ty1 + 1;
/*     */ 
/*     */     
/*  96 */     CLIMATE climate = (CLIMATE)(WORLD.CLIMATE()).getter.get(cx, cy);
/*     */     
/*  98 */     b.textLL((CLIMATES.INFO()).name);
/*  99 */     b.tab(6);
/* 100 */     b.text(((CLIMATE)(WORLD.CLIMATE()).getter.get(cx, cy)).name);
/* 101 */     b.NL();
/*     */     
/* 103 */     climate.boosters.hover((GUI_BOX)b, 1.0D, null, this.filter, -1);
/*     */     
/* 105 */     b.NL();
/*     */     
/* 107 */     double cl = race.population().climate(climate);
/* 108 */     if (cl < race.population().maxClimate()) {
/* 109 */       GText t = b.text();
/* 110 */       t.add(¤¤climate);
/* 111 */       t.insert(0, race.info.names);
/* 112 */       t.insert(1, climate.name);
/* 113 */       t.warnify();
/* 114 */       b.add((SPRITE)t);
/*     */     } 
/*     */     
/* 117 */     b.sep();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     for (Minable m : RESOURCES.minables().all()) {
/* 123 */       double d = 0.0D;
/* 124 */       for (TERRAIN te : TERRAINS.ALL()) {
/* 125 */         d += this.info.get(te).getD() * m.terrain(te);
/*     */       }
/* 127 */       b.add((SPRITE)m.resource.icon());
/* 128 */       b.add((SPRITE)GFORMAT.perc(b.text(), 4.0D * d));
/*     */     } 
/*     */     
/* 131 */     b.NL(4);
/*     */     
/* 133 */     b.textLL(¤¤moisture);
/* 134 */     b.tab(6);
/* 135 */     b.add((SPRITE)GFORMAT.percGood(b.text(), this.info.fertility().getD()));
/* 136 */     b.NL();
/* 137 */     b.text(¤¤moistureD);
/* 138 */     b.NL(8);
/*     */     
/* 140 */     double v = 0.0D;
/* 141 */     for (TERRAIN te : TERRAINS.ALL()) {
/*     */       
/* 143 */       if (this.info.get(te).getD() > 0.0D) {
/* 144 */         b.textLL(te.name);
/* 145 */         b.tab(6);
/* 146 */         b.add((SPRITE)GFORMAT.percGood(b.text(), this.info.get(te).getD()));
/* 147 */         b.NL();
/* 148 */         b.text(te.desc);
/* 149 */         b.NL(8);
/*     */       } 
/* 151 */       double t = this.area.get(te).getD() * race.population().terrain(te);
/* 152 */       for (CLIMATE c : CLIMATES.ALL())
/* 153 */         v += t * race.population().climate(c) * this.area.get(c).getD(); 
/*     */     } 
/* 155 */     v /= race.population().maxClimate() * race.population().maxTerrain();
/*     */     
/* 157 */     if (v < 0.25D) {
/* 158 */       b.add((SPRITE)b.text().warnify().add(¤¤neigh));
/*     */     }
/*     */     
/* 161 */     b.sep();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     b.NL(8);
/*     */     
/* 187 */     int size = getSize(cx, cy, 1500);
/*     */     
/* 189 */     if (size < 750) {
/* 190 */       b.add((SPRITE)b.text().warnify().add(¤¤isolated));
/* 191 */       b.NL(8);
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getSize(int sx, int sy, int max) {
/* 213 */     GUTIL.flooder().init(this);
/* 214 */     GUTIL.flooder().pushSloppy(sx, sy, 0.0D);
/* 215 */     this.area.clear();
/* 216 */     int size = 0;
/* 217 */     while (GUTIL.flooder().hasMore() && size < max) {
/* 218 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 219 */       size++;
/* 220 */       this.area.add(t.x(), t.y());
/* 221 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 222 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 223 */         int toX = t.x() + d.x();
/* 224 */         int toY = t.y() + d.y();
/* 225 */         if (WORLD.IN_BOUNDS(toX, toY))
/*     */         {
/* 227 */           if (!(WORLD.WATER()).has.is(t.x(), t.y()) || 
/* 228 */             WORLD.WATER().canCrossByLand(t.x(), t.y(), toX, toY))
/*     */           {
/*     */             
/* 231 */             if (!WORLD.MOUNTAIN().coversTile(toX, toY))
/*     */             {
/*     */               
/* 234 */               if ((WORLD.FOREST()).amount.get(t.x(), t.y()) != 1.0D || (WORLD.FOREST()).amount.get(toX, toY) != 1.0D)
/*     */               {
/*     */                 
/* 237 */                 GUTIL.flooder().pushSmaller(toX, toY, t.getValue() + d.tileDistance()); }  }  } 
/*     */         }
/*     */       } 
/*     */     } 
/* 241 */     this.area.divide(size);
/* 242 */     GUTIL.flooder().done();
/* 243 */     return size;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\tools\UIWorldToolCapitolPlaceInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */