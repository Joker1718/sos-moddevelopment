/*     */ package game.tourism;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.BonusExperience;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.text.DicTime;
/*     */ import util.text.Inserter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Review
/*     */   implements Serializable, SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  41 */   public final Str.StringReusableSer name = new Str.StringReusableSer(64);
/*  42 */   public final Str.StringReusableSer rating = new Str.StringReusableSer(128);
/*  43 */   public final Str.StringReusableSer attraction = new Str.StringReusableSer(128);
/*  44 */   public final Str.StringReusableSer service = new Str.StringReusableSer(128);
/*  45 */   public final Str.StringReusableSer inn = new Str.StringReusableSer(128);
/*  46 */   public double score = 0.0D;
/*     */   
/*     */   public int credits;
/*     */   
/*     */   public void save(FilePutter file) {
/*  51 */     this.name.save(file);
/*  52 */     this.rating.save(file);
/*  53 */     this.attraction.save(file);
/*  54 */     this.service.save(file);
/*  55 */     this.inn.save(file);
/*  56 */     file.d(this.score);
/*  57 */     file.i(this.credits);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  62 */     this.name.load(file);
/*  63 */     this.rating.load(file);
/*  64 */     this.attraction.load(file);
/*  65 */     this.service.load(file);
/*  66 */     this.inn.load(file);
/*  67 */     this.score = file.d();
/*  68 */     this.credits = file.i();
/*     */   }
/*     */   
/*     */   public void copyOther(Review other) {
/*  72 */     this.name.clear().add((CharSequence)other.name);
/*  73 */     this.rating.clear().add((CharSequence)other.rating);
/*  74 */     this.attraction.clear().add((CharSequence)other.attraction);
/*  75 */     this.service.clear().add((CharSequence)other.service);
/*  76 */     this.inn.clear().add((CharSequence)other.inn);
/*  77 */     this.score = other.score;
/*  78 */     this.credits = other.credits;
/*     */   }
/*     */   
/*     */   public boolean has() {
/*  82 */     return (this.name.length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  87 */     this.name.clear();
/*  88 */     this.score = 0.0D;
/*     */   }
/*     */   
/*     */   public void make(Induvidual indu, COORDINATE inn) {
/*  92 */     Inserter.setRandom(RND.rLong());
/*     */     
/*  94 */     this.name.clear();
/*  95 */     this.name.s().add('/').s();
/*  96 */     this.name.add(STATS.APPEARANCE().name(indu));
/*  97 */     this.name.NL();
/*  98 */     this.name.add((CharSequence)DicTime.setDate(Str.TMP.clear(), (int)TIME.currentSecond()));
/*     */     
/* 100 */     Text.InsertData d = Text.dd;
/* 101 */     d.i = indu;
/* 102 */     d.inn = inn;
/*     */ 
/*     */     
/* 105 */     this.score = 0.0D;
/* 106 */     Race race = indu.race();
/* 107 */     this.credits = 0;
/* 108 */     Text da = (race.tourism()).data;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     RoomBlueprintIns<?> roomBlueprintIns = TOURISM.attraction(indu);
/*     */     
/* 115 */     double s = CLAMP.d(roomBlueprintIns.employment().employed() / max((RoomBlueprintImp)roomBlueprintIns), 0.0D, 1.0D);
/* 116 */     this.score += s;
/* 117 */     if (s == 0.0D) {
/* 118 */       d.rating = 0.0D;
/*     */     } else {
/* 120 */       d.rating = 0.5D + s * 0.5D + RND.rFloat0(0.15D);
/* 121 */     }  this.attraction.clear().add((CharSequence)da.attraction.get(d));
/*     */ 
/*     */     
/* 124 */     this.score += setService(d, this.service.clear());
/*     */     
/* 126 */     if (inn != null && (SETT.ROOMS()).INN.get(inn) != null) {
/* 127 */       ROOM_SERVICER in = (ROOM_SERVICER)(SETT.ROOMS()).INN.get(inn);
/* 128 */       this.score += in.quality();
/* 129 */       d.rating = 0.35D + 0.65D * in.quality();
/* 130 */       this.inn.clear().add((CharSequence)da.inn.get(d));
/*     */     } 
/*     */     
/* 133 */     this.score /= 3.0D;
/*     */     
/* 135 */     this.credits = (int)(this.score * (race.tourism()).credits * TOURISM.CREDITS * RND.rFloat1(0.2D));
/* 136 */     this.score += RND.rFloat0(0.2D);
/* 137 */     this.score = CLAMP.d(this.score, 0.0D, 1.0D);
/*     */     
/* 139 */     d.rating = this.score;
/* 140 */     this.rating.clear().add((CharSequence)da.rating.get(d));
/*     */   }
/*     */ 
/*     */   
/*     */   private double max(RoomBlueprintImp a) {
/* 145 */     for (BonusExperience.RoomExperienceBonus e : (SETT.ROOMS()).exp.ALL()) {
/* 146 */       if (e.blue == a) {
/* 147 */         return e.maxEmployed;
/*     */       }
/*     */     } 
/* 150 */     return 1000.0D;
/*     */   }
/*     */   
/*     */   private double setService(Text.InsertData d, Str tmp) {
/* 154 */     Text da = (d.i.race().tourism()).data;
/*     */     
/* 156 */     StatService ss = TOURISM.service(d.i);
/*     */     
/* 158 */     if (ss != null) {
/* 159 */       d.rating = ss.total().indu().getD(d.i);
/* 160 */       if (d.rating == 0.0D) {
/* 161 */         d.rating = 0.0D;
/*     */       } else {
/* 163 */         d.rating = 0.5D + d.rating * 0.5D + RND.rFloat0(0.15D);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 168 */       tmp.add((CharSequence)da.service.get(d));
/* 169 */       return d.rating;
/*     */     } 
/*     */     
/* 172 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int render(SPRITE_RENDERER r, int x1, int y1, int width) {
/* 178 */     int icons = (int)(1.0D + 4.0D * this.score);
/* 179 */     int x = x1 + width / 2 - 16 * icons / 2;
/* 180 */     for (int i = 0; i < icons; i++) {
/* 181 */       (SPRITES.icons()).s.star.render(r, x, y1);
/* 182 */       x += 16;
/*     */     } 
/*     */     
/* 185 */     Str.TMP.clear().add(this.credits);
/* 186 */     x = x1 + width - 128;
/* 187 */     (SPRITES.icons()).s.money.render(r, x, y1);
/* 188 */     (GCOLOR.T()).H1.bind();
/* 189 */     (UI.FONT()).S.render(r, (CharSequence)Str.TMP, x + 6 + 24, y1);
/* 190 */     COLOR.unbind();
/*     */     
/* 192 */     y1 += 20;
/*     */ 
/*     */ 
/*     */     
/* 196 */     (GCOLOR.T()).NORMAL2.bind();
/* 197 */     if (this.rating != null)
/* 198 */       y1 += 8 + (UI.FONT()).M.render(r, (CharSequence)this.rating, x1, y1, width, 1.0D); 
/* 199 */     if (this.attraction != null)
/* 200 */       y1 += 8 + (UI.FONT()).M.render(r, (CharSequence)this.attraction, x1, y1, width, 1.0D); 
/* 201 */     if (this.service != null)
/* 202 */       y1 += 8 + (UI.FONT()).M.render(r, (CharSequence)this.service, x1, y1, width, 1.0D); 
/* 203 */     if (this.inn != null)
/* 204 */       y1 += 8 + (UI.FONT()).M.render(r, (CharSequence)this.inn, x1, y1, width, 1.0D); 
/* 205 */     (GCOLOR.T()).H2.bind();
/* 206 */     y1 += (UI.FONT()).S.render(r, (CharSequence)this.name, x1 + 30, y1, width - 30, 1.0D);
/* 207 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */     
/* 211 */     return y1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderScore(SPRITE_RENDERER r, int cx, int y1) {
/* 218 */     int icons = (int)(1.0D + 4.0D * this.score);
/* 219 */     int x = icons * 16 / 2;
/* 220 */     x = cx - x;
/* 221 */     for (int i = 0; i < icons; i++) {
/* 222 */       (SPRITES.icons()).s.star.render(r, x, y1);
/* 223 */       x += 16;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderCred(SPRITE_RENDERER r, int x1, int y1) {
/* 230 */     Str.TMP.clear().add(this.credits);
/* 231 */     (SPRITES.icons()).s.money.render(r, x1, y1);
/* 232 */     (GCOLOR.T()).H1.bind();
/* 233 */     (UI.FONT()).S.render(r, (CharSequence)Str.TMP, x1 + 6 + 24, y1);
/* 234 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Review.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */