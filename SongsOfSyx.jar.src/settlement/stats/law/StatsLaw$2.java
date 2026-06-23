/*     */ package settlement.stats.law;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.arena.pit.ROOM_FIGHTPIT;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ class null
/*     */   extends STATFakeData
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/*  89 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getDD(HCLASS cl, Race race) {
/*  94 */     double tot = 0.0D;
/*  95 */     double access = 0.0D;
/*  96 */     double rate = 0.0D;
/*  97 */     double rateTot = CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, null);
/*  98 */     for (ROOM_FIGHTPIT r : (SETT.ROOMS()).FIGHTPITS) {
/*  99 */       tot++;
/* 100 */       access += r.service().stats().access().data(cl).getD(race);
/*     */       
/* 102 */       for (Race race2 : RACES.all()) {
/* 103 */         if (r.punishEnabled().is(race2)) {
/* 104 */           rate += CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, race2);
/*     */         }
/*     */       } 
/*     */     } 
/* 108 */     access /= tot;
/*     */ 
/*     */     
/* 111 */     access *= CLAMP.d(4.0D * rate / rateTot, 0.0D, 1.0D);
/*     */     
/* 113 */     return access;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race race) {
/* 119 */     GBox b = (GBox)text;
/*     */ 
/*     */ 
/*     */     
/* 123 */     b.textLL(Dic.¤¤Access);
/* 124 */     b.NL();
/* 125 */     for (ROOM_FIGHTPIT r : (SETT.ROOMS()).FIGHTPITS) {
/* 126 */       b.add((SPRITE)r.icon);
/* 127 */       b.textLL(r.info.name);
/* 128 */       b.NL();
/* 129 */       b.textLL(Dic.¤¤Access);
/* 130 */       b.tab(6);
/* 131 */       b.add((SPRITE)GFORMAT.perc(b.text(), r.service().stats().access().data(cl).getD(race)));
/* 132 */       b.NL();
/*     */       
/* 134 */       double rateTot = CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, null);
/* 135 */       double rate = 0.0D;
/*     */       
/* 137 */       for (Race race2 : RACES.all()) {
/* 138 */         if (r.punishEnabled().is(race2)) {
/* 139 */           b.add((SPRITE)(race2.appearance()).icon);
/* 140 */           rate += CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, race2);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 145 */       b.NL();
/*     */       
/* 147 */       if (rateTot == 0.0D) {
/* 148 */         rate = 0.0D;
/*     */       } else {
/* 150 */         rate /= rateTot;
/*     */       } 
/* 152 */       b.textLL((CRIME_PUNISHMENTS.EXECUTE()).names);
/* 153 */       b.tab(6);
/* 154 */       GText t = b.text();
/* 155 */       GFORMAT.perc(t, rate, 0);
/* 156 */       t.add('/');
/* 157 */       GFORMAT.perc(t, 0.25D, 0);
/* 158 */       t.normalify();
/* 159 */       b.add((SPRITE)t);
/* 160 */       b.NL();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     super.hover(text, cl, race);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatsLaw$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */