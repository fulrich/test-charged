#!/bin/bash
set -e

git config --global user.email "9284621+fulrich@users.noreply.github.com"
git config --global user.name "fulrich"
git config --global push.default simple

sbt docs/publishMicrosite
