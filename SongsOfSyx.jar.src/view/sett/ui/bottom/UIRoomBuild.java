/*     */ package view.sett.ui.bottom;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.religion.Religion;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.spirit.shrine.ROOM_SHRINE;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.room.water.pool.ROOM_POOL;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.slider.GGaugeMutable;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class UIRoomBuild {
/*  45 */   private static CharSequence ¤¤cost = "¤Costs";
/*  46 */   private static CharSequence ¤¤production = "¤Production";
/*  47 */   private static CharSequence ¤¤optional = "¤(Optional)";
/*  48 */   private static CharSequence ¤¤Emits = "¤Emits";
/*  49 */   private static CharSequence ¤¤CurrentRooms = "¤Current Rooms";
/*  50 */   private static CharSequence ¤¤CurrentBelievers = "¤Current Worshippers";
/*     */   
/*     */   static {
/*  53 */     D.ts(UIRoomBuild.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hoverRoomBuild(RoomBlueprintImp b, GUI_BOX text) {
/*  63 */     GBox box = (GBox)text;
/*  64 */     box.title(b.info.name);
/*  65 */     box.text(b.info.desc);
/*  66 */     box.NL();
/*     */     
/*  68 */     if (b instanceof ROOM_TEMPLE || b instanceof ROOM_SHRINE) {
/*  69 */       Religion rel = null;
/*  70 */       if (b instanceof ROOM_TEMPLE) {
/*  71 */         rel = ((ROOM_TEMPLE)b).religion;
/*     */       } else {
/*  73 */         rel = ((ROOM_SHRINE)b).religion;
/*     */       } 
/*     */       
/*  76 */       box.textLL(¤¤CurrentBelievers);
/*  77 */       box.add((SPRITE)GFORMAT.perc(box.text(), ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(rel.index())).followers.data().getD(null)));
/*  78 */       box.NL();
/*     */     } 
/*     */ 
/*     */     
/*  82 */     b.reqs.hover(text, FACTIONS.player());
/*     */     
/*  84 */     box.sep();
/*     */     
/*  86 */     if (b instanceof RoomBlueprintIns) {
/*  87 */       RoomBlueprintIns<?> ins = (RoomBlueprintIns)b;
/*  88 */       box.NL(2);
/*  89 */       box.textLL(¤¤CurrentRooms);
/*  90 */       box.add((SPRITE)GFORMAT.i(box.text(), ins.instancesSize()));
/*     */     } 
/*     */     
/*  93 */     box.NL(8);
/*     */     
/*  95 */     boolean e = false;
/*  96 */     for (SettEnvMap.SettEnv en : (SETT.ENV()).map.all()) {
/*  97 */       if (b.constructor().envValue(en)) {
/*  98 */         if (!e) {
/*  99 */           box.textLL(¤¤Emits);
/* 100 */           e = true;
/*     */         } 
/* 102 */         box.text(en.info.name);
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     box.NL();
/*     */     
/* 108 */     if (b.employment() != null) {
/* 109 */       box.textLL(Dic.¤¤AccidentRate);
/* 110 */       box.add((SPRITE)GFORMAT.perc(box.text(), (b.employment()).accidentsPerYear / (1.0D + (BOOSTABLES.CIVICS()).ACCIDENT.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null))), 4));
/* 111 */       box.NL();
/*     */     } 
/*     */     
/* 114 */     if (b.constructor().resources() > 0) {
/* 115 */       box.NL(8);
/* 116 */       box.textLL(¤¤cost);
/* 117 */       int o = 0; int ri;
/* 118 */       for (ri = 0; ri < b.constructor().resources(); ri++) {
/* 119 */         if (b.upgrades().resMask(0, ri) != 0.0D)
/*     */         {
/* 121 */           if (optional(b.constructor(), ri)) {
/* 122 */             o++;
/*     */           } else {
/*     */             
/* 125 */             box.add((SPRITE)b.constructor().resource(ri).icon());
/*     */           }  } 
/*     */       } 
/* 128 */       if (o > 0) {
/* 129 */         box.space().space();
/* 130 */         box.add((SPRITE)box.text().lablifySub().add(¤¤optional));
/* 131 */         for (ri = 0; ri < b.constructor().resources(); ri++) {
/* 132 */           if (b.upgrades().resMask(0, ri) != 0.0D)
/*     */           {
/* 134 */             if (optional(b.constructor(), ri)) {
/* 135 */               box.add((SPRITE)b.constructor().resource(ri).icon());
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/* 140 */       box.NL();
/*     */     } 
/*     */     
/* 143 */     if (b instanceof INDUSTRY_HASER) {
/* 144 */       box.NL(8);
/* 145 */       box.textLL(¤¤production);
/* 146 */       box.NL();
/*     */       
/* 148 */       for (Industry i : ((INDUSTRY_HASER)b).industries()) {
/* 149 */         if (i.outs().size() == 0) {
/* 150 */           for (IndustryResource r : i.ins()) {
/* 151 */             box.add((SPRITE)r.resource.icon()).add((SPRITE)GFORMAT.f0(box.text(), -r.rate * ((i.bonus() == null) ? 1.0D : i.bonus().get((BOOSTABLE_O)FACTIONS.player()))));
/* 152 */             box.space();
/*     */           } 
/*     */         } else {
/*     */           int ri;
/* 156 */           for (ri = 0; ri < i.ins().size(); ri++) {
/* 157 */             IndustryResource r = (IndustryResource)i.ins().get(ri);
/* 158 */             box.add((SPRITE)r.resource.icon()).add((SPRITE)GFORMAT.f0(box.text(), -r.rate * i.bonus().get((BOOSTABLE_O)FACTIONS.player())));
/* 159 */             if (ri < i.ins().size() - 1) {
/* 160 */               box.add((SPRITE)box.text().add('&'));
/*     */             }
/*     */           } 
/* 163 */           box.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/*     */           
/* 165 */           for (ri = 0; ri < i.outs().size(); ri++) {
/* 166 */             IndustryResource r = (IndustryResource)i.outs().get(ri);
/* 167 */             box.add((SPRITE)r.resource.icon()).add((SPRITE)GFORMAT.fRel(box.text(), r.rate * i.bonus().get((BOOSTABLE_O)FACTIONS.player()), r.rate));
/* 168 */             if (ri < i.outs().size() - 1) {
/* 169 */               box.add((SPRITE)(SPRITES.icons()).s.plus);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 175 */         if (!i.lockable().passes(FACTIONS.player())) {
/* 176 */           box.add((SPRITE)(SPRITES.icons()).m.lock);
/* 177 */           box.NL();
/* 178 */           i.lockable().hover(text, FACTIONS.player());
/*     */         } 
/*     */         
/* 181 */         box.sep();
/*     */       } 
/*     */       
/* 184 */       if (b.bonus() != null) {
/* 185 */         int tab = 0;
/* 186 */         for (Race r : RACES.all()) {
/* 187 */           box.tab(tab * 2);
/* 188 */           box.add((SPRITE)(r.appearance()).icon);
/* 189 */           double d = RACES.boosts().getNorSkill(r, b.employment());
/* 190 */           GGaugeMutable.bad2Good(ColorImp.TMP, d);
/* 191 */           int am = (int)Math.ceil(0.1D + d * 3.0D);
/* 192 */           am = CLAMP.i(am, 0, 3);
/* 193 */           box.rewind(4);
/* 194 */           for (int i = 0; i < am; i++) {
/*     */             
/* 196 */             box.add((SPRITE)(SPRITES.icons()).s.hammer, (COLOR)ColorImp.TMP);
/* 197 */             box.rewind(8);
/*     */           } 
/*     */           
/* 200 */           tab++;
/* 201 */           if (tab > 6) {
/* 202 */             box.NL();
/* 203 */             tab = 0;
/*     */           } 
/*     */         } 
/* 206 */         box.NL();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 212 */     STAT stat = null;
/* 213 */     if (b instanceof RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER) {
/* 214 */       stat = ((RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER)b).service().stats().total();
/* 215 */     } else if (b instanceof ROOM_MONUMENT) {
/* 216 */       ROOM_MONUMENT m = (ROOM_MONUMENT)b;
/* 217 */       stat = (STAT)(STATS.ACCESS()).MONUMENTS.ALL().get(m.monumentIndex);
/*     */     } 
/* 219 */     if (stat != null) {
/* 220 */       box.NL(4);
/* 221 */       box.textLL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 222 */       box.NL();
/* 223 */       int tab = 0;
/* 224 */       double min = 0.0D;
/* 225 */       double max = 0.0D;
/* 226 */       for (Race r : RACES.all()) {
/* 227 */         StatStanding d = stat.standing();
/* 228 */         if ((d.definition(r)).inverted) {
/* 229 */           min = Math.max(min, (d.definition(r).get(HCLASSES.CITIZEN())).max); continue;
/*     */         } 
/* 231 */         max = Math.max(max, (d.definition(r).get(HCLASSES.CITIZEN())).max);
/*     */       } 
/*     */       
/* 234 */       for (Race r : RACES.all()) {
/*     */ 
/*     */         
/* 237 */         StatStanding d = stat.standing();
/* 238 */         COLOR c = (GCOLOR.UI()).GOOD.hovered;
/* 239 */         Icons.S.IconS iconS = (SPRITES.icons()).s.arrowUp;
/* 240 */         int am = (int)(3.0D * Math.ceil(CLAMP.d((d.definition(r).get(HCLASSES.CITIZEN())).max / max, 0.0D, max)));
/* 241 */         if ((d.definition(r)).inverted) {
/* 242 */           iconS = (SPRITES.icons()).s.arrowDown;
/* 243 */           c = (GCOLOR.UI()).BAD.hovered;
/* 244 */           am = (int)(4L * Math.round(CLAMP.d((d.definition(r).get(HCLASSES.CITIZEN())).max / min, 0.0D, min)));
/*     */         } 
/* 246 */         box.tab(tab * 2);
/* 247 */         box.add((SPRITE)(r.appearance()).icon);
/* 248 */         box.rewind(4);
/* 249 */         for (int i = 0; i < am; i++) {
/*     */           
/* 251 */           box.add((SPRITE)iconS, c);
/* 252 */           box.rewind(8);
/*     */         } 
/*     */         
/* 255 */         tab++;
/* 256 */         if (tab > 8) {
/* 257 */           box.NL();
/* 258 */           tab = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     if (b instanceof ROOM_POOL) {
/* 267 */       ROOM_POOL pool = (ROOM_POOL)b;
/* 268 */       for (Race r : RACES.all()) {
/* 269 */         double d = r.pref().pool(pool);
/* 270 */         int k = 1 + (int)(5.0D * d);
/* 271 */         if ((r.index & 0x3) == 0)
/* 272 */           box.NL(); 
/* 273 */         box.tab((r.index & 0x3) * 3);
/* 274 */         box.add((SPRITE)(r.appearance()).icon);
/* 275 */         ColorImp.TMP.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD.hovered, d);
/* 276 */         for (int i = 0; i < k; i++) {
/* 277 */           box.add((SPRITE)(SPRITES.icons()).s.heart, (COLOR)ColorImp.TMP);
/* 278 */           box.rewind(8);
/*     */         } 
/* 280 */         box.space();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean optional(Furnisher f, int ri) {
/* 289 */     if (f.areaCost(ri, 0) > 0.0D)
/* 290 */       return false; 
/* 291 */     if (!f.usesArea())
/* 292 */       return false; 
/* 293 */     for (FurnisherItemGroup g : f.groups()) {
/* 294 */       if (needed(f, g) && g.cost(ri, 0) > 0.0D) {
/* 295 */         return false;
/*     */       }
/*     */     } 
/* 298 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean needed(Furnisher f, FurnisherItemGroup g) {
/* 302 */     if (g.min > 0) {
/* 303 */       return true;
/*     */     }
/* 305 */     for (FurnisherStat s : f.stats()) {
/* 306 */       if (g.stat(s.index()) > 0.0D && s.min > 0.0D)
/* 307 */         return true; 
/*     */     } 
/* 309 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\UIRoomBuild.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */